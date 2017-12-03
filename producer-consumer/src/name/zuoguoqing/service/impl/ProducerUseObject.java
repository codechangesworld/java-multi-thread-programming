/**
 * 
 */
package name.zuoguoqing.service.impl;

import java.util.List;

import name.zuoguoqing.service.Producer;

/**
 * @author zuoguoqing
 *
 */
public class ProducerUseObject implements Producer {
    private List<Object> list;
    private Object lock;

    public ProducerUseObject(Object lock, List<Object> list) {
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void produce() {
        synchronized (lock) {
            try {
                while (list.size() > 0) {
                    lock.wait();
                }

                // produce
                Thread.sleep(500);
                list.add(new Object());
                System.out.println(Thread.currentThread().getName() + "\tproduce object");

                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
