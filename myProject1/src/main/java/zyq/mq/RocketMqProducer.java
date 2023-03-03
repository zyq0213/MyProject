package zyq.mq;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zyq.model.entity.User;

/**
 * @author yanqing.zou
 * @date 2022-08-23 17:11
 * Description
 */
@Slf4j
public class RocketMqProducer {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("productGroup1");
        defaultMQProducer.setNamesrvAddr("127.0.0.1:9876");
        defaultMQProducer.start();

        Message message = new Message("topic1", JSON.toJSONString(new User("test1", 1, '男')).getBytes());

        SendResult sendResult = defaultMQProducer.send(message);
        log.info("sendResult:{}",JSON.toJSONString(sendResult,true));


        defaultMQProducer.shutdown();
    }

}
