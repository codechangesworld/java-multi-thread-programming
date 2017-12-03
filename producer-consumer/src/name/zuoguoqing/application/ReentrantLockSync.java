/**
 * 
 */
package name.zuoguoqing.application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import name.zuoguoqing.service.Consumer;
import name.zuoguoqing.service.Producer;
import name.zuoguoqing.service.impl.ConsumerUseLock;
import name.zuoguoqing.service.impl.ProducerUseLock;
import name.zuoguoqing.util.ProducerConsumerModelUtil;

/**
 * @author zuoguoqing
 *
 */
public class ReentrantLockSync {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionProducer = lock.newCondition();
        Condition conditionConsumer = lock.newCondition();
        List<Object> list = new ArrayList<>();
        
        Producer producer = new ProducerUseLock(lock, conditionProducer, conditionConsumer, list);
        Consumer consumer = new ConsumerUseLock(lock, conditionProducer, conditionConsumer, list);
        
        ProducerConsumerModelUtil.singleAndSingle(producer, consumer);
        
//        ProducerConsumerModelUtil.singleAndMulti(producer, consumer);
        
//        ProducerConsumerModelUtil.multiAndSingle(producer, consumer);
        
//        ProducerConsumerModelUtil.multiAndMulty(producer, consumer);
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.exit(0);
    }

}
