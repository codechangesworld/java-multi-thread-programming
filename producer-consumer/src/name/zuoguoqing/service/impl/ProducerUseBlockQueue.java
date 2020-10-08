/**
 * 
 */
package name.zuoguoqing.service.impl;

import java.util.concurrent.BlockingQueue;

import name.zuoguoqing.service.Producer;

/**
 * @author zuoguoqing
 *
 */
public class ProducerUseBlockQueue implements Producer {
    private BlockingQueue<Object> queue;
    
    public ProducerUseBlockQueue(BlockingQueue<Object> queue) {
        super();
        this.queue = queue;
    }

    /* (non-Javadoc)
     * @see name.zuoguoqing.service.Producer#produce()
     */
    @Override
    public void produce() {
        try {
            queue.put(new Object());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\tproduce object");
    }

}
