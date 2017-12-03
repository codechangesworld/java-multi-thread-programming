/**
 * 
 */
package name.zuoguoqing.service.impl;

import java.util.List;

import name.zuoguoqing.service.Consumer;

/**
 * @author zuoguoqing
 *
 */
public class ConsumerUseObject implements Consumer {
    private List<Object> list;
    private Object lock;

    public ConsumerUseObject(Object lock, List<Object> list) {
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void consume() {

        synchronized (lock) {
            try {
                while (list.size() == 0) {
                    // System.out.println(Thread.currentThread().getName() + " no
                    // object, waiting...");
                    lock.wait();
                }

                // consume object
                Thread.sleep(500);
                list.remove(0);
                System.out.println(Thread.currentThread().getName() + "\tconsume object");

                lock.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
