package tree;

import A_entity.TreeNode;

import java.util.*;

/**
 * @author yanqing.zou
 * @date 2023-03-06 19:38
 * Description
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,15,7,null,null]，
 *
 *      3
 *     / \
 *    9  20
 *  /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A104_binaryTreeMaxDepth {
    /**
     * 前序遍历，第一时间想到的，通过遍历和map来存储每个节点的值。
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        //新增一个map，key存二叉树，value存度。
        int maxDepth = 0;
        List<TreeNode> list = new ArrayList<>();
        Map<TreeNode, Integer> treeMap = new TreeMap<>();

        Deque<TreeNode> deque = new LinkedList<>();
        while(root != null || !deque.isEmpty()){
            while (root != null ){
                //判断treeMap里面有没有,没有的话是第一个
                int value = 1;
                if(treeMap.containsKey(root)){
                     value = treeMap.get(root);
                }else{
                    treeMap.put(root,1);
                }
                if(root.left != null){
                    maxDepth = Math.max(maxDepth, value + 1);
                    treeMap.put(root.left,value+1);
                }
                if(root.right != null){
                    maxDepth = Math.max(maxDepth, value + 1);
                    treeMap.put(root.right,value+1);
                }
                list.add(root);
                deque.addFirst(root);
                root = root.left;
            }
            root = deque.removeFirst();
            root = root.right;
        }
        //输出list
        StringBuilder sb= new StringBuilder();
        for (TreeNode node : list) {
            sb.append(node.val).append("->");
        }
        System.out.println(sb.substring(0,sb.length()-2));
        //输出map
        Comparator<Map.Entry<TreeNode, Integer>> comparator = Comparator.comparingInt(Map.Entry::getValue);
        List<Map.Entry<TreeNode, Integer>> entries = new ArrayList<>(treeMap.entrySet());
        entries.sort(comparator);
        for (Map.Entry<TreeNode, Integer> entry : entries) {
            System.out.println("node:"+entry.getKey().val+"   depth:"+entry.getValue());
        }
        return maxDepth;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return Math.max(left, right) + 1;

    }

    /**
     * dfs , 一个节点 left和right的时候，它的深度一定+1，按照这个规律，就可以直接遍历
     * 遍历一个节点的时候，把这个节点的值+1传给下一个节点
     * 这种方法实则是和maxDepth1的递归方法没什么区别，都是深度优先，递归回溯
     * @param root
     *
     dfs
     执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     内存消耗：41 MB, 在所有 Java 提交中击败了81.20%的用户
     通过测试用例：39 / 39

     */
    static int  maxDepth = 0;
    public static int maxDepth2(TreeNode root){
        if(root == null){
            return maxDepth;
        }
        dfs(root, maxDepth);

        return maxDepth;
    }

    public static void dfs(TreeNode node, int depth){
        if(node == null){
            return ;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
        maxDepth = Math.max(maxDepth,depth+1);
    }

    /**
     * bfs 广度优先，对树的宽度进行遍历
     * 看了下概念，尝试着写出来
     * @param root
     *
     执行用时：3 ms, 在所有 Java 提交中击败了0.70%的用户
     内存消耗：41.1 MB, 在所有 Java 提交中击败了64.61%的用户
     通过测试用例：39 / 39
     */
    public static int bfs(TreeNode root){
        int maxDepth = 0;
        if(root == null) {
            return maxDepth;
        }
        Deque<TreeNode> inQueue = new LinkedList<>();
        //1.先把初始的根节点加入到 inQueue
        inQueue.push(root);
        //2.新建一个newQueue，用来判断不同层数
        Deque<TreeNode> newQueue = new LinkedList<>();
        while (!inQueue.isEmpty()){
            //3.开始对inQueue进行操作，拿出一个节点，就对该节点左右子节点入栈操作,
            TreeNode node = inQueue.removeLast();
            if(node.left != null){
                newQueue.push(node.left);
            }
            if(node.right != null){
                newQueue.push(node.right);
            }
            //4.检测inQueue是否为空,如果为空，就把inQueue的值转移到newQueue
            if(inQueue.isEmpty()){
               while (!newQueue.isEmpty()){
                   inQueue.push(newQueue.removeLast());
               }
               //5.inQueue每清空一次，就是消耗掉了一层
               ++maxDepth;
            }
        }
        return maxDepth;
    }


    public static void main(String[] args) {
        /**
         *         1
         *      2      3
         *    4   5  6   7
         * 10   8
         * 前序遍历, the result is: 1 2 4 10 8 5 3 6 7
         */
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(10);
        treeNode.left.left.right = new TreeNode(8);

        int i = bfs(treeNode);
        System.out.println(i);
    }

}
