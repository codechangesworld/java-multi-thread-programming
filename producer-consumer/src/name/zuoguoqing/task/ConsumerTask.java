/**
 * 
 */
package name.zuoguoqing.task;

import name.zuoguoqing.service.Consumer;

/**
 * @author zuoguoqing
 *
 */
public class ConsumerTask implements Runnable {
    private Consumer consumer;
    
    /**
     * 
     */
    public ConsumerTask(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\tstarting consume...");
        
        while (!Thread.interrupted()) {
            consumer.consume();
        }
    }

}
