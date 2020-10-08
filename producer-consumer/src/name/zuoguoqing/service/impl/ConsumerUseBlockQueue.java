/**
 * 
 */
package name.zuoguoqing.service.impl;

import java.util.concurrent.BlockingQueue;

import name.zuoguoqing.service.Consumer;

/**
 * @author zuoguoqing
 *
 */
public class ConsumerUseBlockQueue implements Consumer {
    private BlockingQueue<Object> queue;
    
    public ConsumerUseBlockQueue(BlockingQueue<Object> queue) {
        super();
        this.queue = queue;
    }

    /* (non-Javadoc)
     * @see name.zuoguoqing.service.Consumer#consume()
     */
    @Override
    public void consume() {
        try {
            queue.take();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(Thread.currentThread().getName() + "\tconsume object");
    }

}
