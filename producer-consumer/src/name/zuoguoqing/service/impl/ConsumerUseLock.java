/**
 * 
 */
package name.zuoguoqing.service.impl;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import name.zuoguoqing.service.Consumer;

/**
 * @author zuoguoqing
 *
 */
public class ConsumerUseLock implements Consumer {
    private ReentrantLock lock;
    private Condition conditionProducer;
    private Condition conditionConsumer;
    private List<Object> list;
    
    public ConsumerUseLock(ReentrantLock lock, Condition conditionProducer, Condition conditionConsumer, List<Object> list) {
        super();
        this.lock = lock;
        this.conditionProducer = conditionProducer;
        this.conditionConsumer = conditionConsumer;
        this.list = list;
    }

    /* (non-Javadoc)
     * @see name.zuoguoqing.service.Consumer#consume()
     */
    @Override
    public void consume() {
        try {
            lock.lock();
            
            while (list.size() == 0) {
                conditionConsumer.await();
            }
            
            Thread.sleep(500);
            list.remove(0);
            System.out.println(Thread.currentThread().getName() + "\tconsume object");
            conditionProducer.signalAll();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
