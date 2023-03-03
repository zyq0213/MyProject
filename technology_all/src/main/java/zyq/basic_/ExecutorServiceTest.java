package zyq.basic_;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;


public class ExecutorServiceTest {
    private  ExecutorService executorService = Executors.newFixedThreadPool(1);

    /**
     * execute and submit Test
     */
     class ExecuteAndSubmitTest {
        /**
         * submit execute Runnable
         */
        public  void test() {
            executorService.execute(() -> {
                System.out.println("executorService1.execute");
            });

            Future<?> submit = executorService.submit(() -> {
                System.out.println("executorService1.submit");
            });

            try {
                System.out.println("submit:" + submit.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        /**
         * submit callable
         */
        public  void test1(){
            Future<Object> submit_callable = executorService.submit(new Callable<Object>() {

                /**
                 * Computes a result, or throws an exception if unable to do so.
                 *
                 * @return computed result
                 * @throws Exception if unable to compute a result
                 */
                @Override
                public Object call() throws Exception {
                    System.out.println("submit callable");
                    return "executorService.submit callable";
                }
            });
            try {
                Object o = submit_callable.get();
                System.out.println(o.toString());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }

        /**
         * invokeAny Test
         */
        public void test2(){
            Set<Callable<String>> callables = new HashSet<>();
            callables.add(()->{
                System.out.println("out invokeAny1");
                return "invokeAny1";
            });
            callables.add(()->{
                System.out.println("out invokeAny2");
                return "invokeAny2";
            });
            try {
                executorService.invokeAll(callables).forEach(v->{
                    String string = null;
                    try {
                        string = v.get().toString();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    System.out.println(string);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void main(String[] args) {
            test2();
            executorService.shutdown();
        }
    }

    class ExecutorsTest{

    }
}
