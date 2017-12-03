/**
 * 
 */
package name.zuoguoqing.service.impl;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import name.zuoguoqing.service.Producer;

/**
 * @author zuoguoqing
 *
 */
public class ProducerUseLock implements Producer {
    private ReentrantLock lock;
    private Condition conditionProducer;
    private Condition conditionConsumer;
    private List<Object> list;
    
    public ProducerUseLock(ReentrantLock lock, Condition conditionProducer, Condition conditionConsumer, List<Object> list) {
        super();
        this.lock = lock;
        this.list = list;
        this.conditionProducer = conditionProducer;
        this.conditionConsumer = conditionConsumer;
    }

    /* (non-Javadoc)
     * @see name.zuoguoqing.service.Consumer#consume()
     */
    @Override
    public void produce() {
        try {
            lock.lock();
            
            while (list.size() > 0) {
                conditionProducer.await();
            }
            
            Thread.sleep(500);
            list.add(new Object());
            System.out.println(Thread.currentThread().getName() + "\tproduce object");
            conditionConsumer.signalAll();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
