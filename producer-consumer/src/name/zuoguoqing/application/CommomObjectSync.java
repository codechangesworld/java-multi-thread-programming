/**
 * 
 */
package name.zuoguoqing.application;

import java.util.ArrayList;
import java.util.List;

import name.zuoguoqing.service.Consumer;
import name.zuoguoqing.service.Producer;
import name.zuoguoqing.service.impl.ConsumerUseObject;
import name.zuoguoqing.service.impl.ProducerUseObject;
import name.zuoguoqing.util.ProducerConsumerModelUtil;

/**
 * @author zuoguoqing
 *
 */
public class CommomObjectSync {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // test data
        Object lock = new Object();
        List<Object> list = new ArrayList<>();
        Producer producer = new ProducerUseObject(lock, list);
        Consumer consumer = new ConsumerUseObject(lock, list);

        // 1:1
        // ProducerConsumerModelUtil.singleAndSingle(producer, consumer);

        // 1:n
        // ProducerConsumerModelUtil.singleAndMulti(producer, consumer);

        // n:1
        // ProducerConsumerModelUtil.multiAndSingle(producer, consumer);

        // n:n
        ProducerConsumerModelUtil.multiAndMulty(producer, consumer);
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.exit(0);

    }

    
}
