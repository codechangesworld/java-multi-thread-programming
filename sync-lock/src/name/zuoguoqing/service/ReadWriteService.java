/**
 * 
 */
package name.zuoguoqing.service;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zuoguoqing
 *
 */
public class ReadWriteService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        lock.readLock().lock();

        try {
            System.out.println(LocalTime.now().toString() + "\t" + Thread.currentThread().getName()
                    + "\tacquire read lock");
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(LocalTime.now().toString() + "\t" + Thread.currentThread().getName()
                    + "\trelease read lock");
            lock.readLock().unlock();
        }
    }

    public void write() {
        lock.writeLock().lock();

        try {
            System.out.println(LocalTime.now().toString() + "\t" + Thread.currentThread().getName()
                    + "\tacquire write lock");
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(LocalTime.now().toString() + "\t" + Thread.currentThread().getName()
                    + "\trelease write lock");
            lock.writeLock().unlock();
        }
    }

}
