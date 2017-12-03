/**
 * 
 */
package name.zuoguoqing.util;

import java.util.Random;

import name.zuoguoqing.service.Consumer;
import name.zuoguoqing.service.Producer;
import name.zuoguoqing.task.ConsumerTask;
import name.zuoguoqing.task.ProduceTask;

/**
 * @author zuoguoqing
 *
 */
public class ProducerConsumerModelUtil {
    
    /**
     * both producer and consumer are single
     * 
     * @param producer
     * @param consumer
     */
    public static void singleAndSingle(Producer producer, Consumer consumer) {

        Thread threadP = new Thread(new ProduceTask(producer), "Thread-P");
        Thread threadC = new Thread(new ConsumerTask(consumer), "Thread-C");

        threadP.start();
        threadC.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * one producer and multi consumer
     * 
     * @param producer
     * @param consumer
     */
    public static void singleAndMulti(Producer producer, Consumer consumer) {
        Thread produceThread = new Thread(new ProduceTask(producer), "Thread-P1");
        Thread[] consumeThreads = new Thread[new Random().nextInt(10) + 1];

        for (int i = 0; i < consumeThreads.length; i++) {
            consumeThreads[i] = new Thread(new ConsumerTask(consumer),
                    "Thread-C" + String.valueOf(i + 1));
        }

        produceThread.start();
        for (Thread thread : consumeThreads) {
            thread.start();
        }
    }

    /**
     * multi producer and single consumer
     * 
     * @param producer
     * @param consumer
     */
    public static void multiAndSingle(Producer producer, Consumer consumer) {
        Thread consumeThread = new Thread(new ConsumerTask(consumer), "Thread-C1");
        Thread[] produceThreads = new Thread[new Random().nextInt(10) + 1];

        consumeThread.start();
        for (int i = 0; i < produceThreads.length; i++) {
            produceThreads[i] = new Thread(new ProduceTask(producer),
                    "Thread-P" + String.valueOf(i + 1));
            produceThreads[i].start();
        }
    }

    /**
     * multi producer and multi consumer
     * 
     * @param producer
     * @param consumer
     */
    public static void multiAndMulty(Producer producer, Consumer consumer) {
        Thread[] produceThreads = new Thread[new Random().nextInt(10) + 1];
        Thread[] consumeThreads = new Thread[new Random().nextInt(10) + 1];

        for (int i = 0; i < produceThreads.length; i++) {
            produceThreads[i] = new Thread(new ProduceTask(producer),
                    "Thread-P" + String.valueOf(i + 1));
            produceThreads[i].start();
        }
        for (int i = 0; i < consumeThreads.length; i++) {
            consumeThreads[i] = new Thread(new ConsumerTask(consumer),
                    "Thread-C" + String.valueOf(i + 1));
            consumeThreads[i].start();
        }
    }
}
