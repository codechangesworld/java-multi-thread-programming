/**
 * 
 */
package name.zuoguoqing.application;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import name.zuoguoqing.service.Consumer;
import name.zuoguoqing.service.Producer;
import name.zuoguoqing.service.impl.ConsumerUseBlockQueue;
import name.zuoguoqing.service.impl.ProducerUseBlockQueue;
import name.zuoguoqing.util.ProducerConsumerModelUtil;

/**
 * @author zuoguoqing
 *
 */
public class BlockQueueSync {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
        Producer producer = new ProducerUseBlockQueue(queue);
        Consumer consumer = new ConsumerUseBlockQueue(queue);
        
//        ProducerConsumerModelUtil.singleAndSingle(producer, consumer);
        
//        ProducerConsumerModelUtil.singleAndMulti(producer, consumer);
        
//        ProducerConsumerModelUtil.multiAndSingle(producer, consumer);
        
        ProducerConsumerModelUtil.multiAndMulty(producer, consumer);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.exit(0);
    }

}
