/**
 * 
 */
package name.zuoguoqing.app;

import java.util.Random;

import name.zuoguoqing.service.ReadWriteService;
import name.zuoguoqing.task.ReadTask;
import name.zuoguoqing.task.WriteTask;

/**
 * @author zuoguoqing
 *
 */
public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ReadWriteService service = new ReadWriteService();
        
//        multiRead(service);
        
//        multiWrite(service);
        
        multiReadWrite(service);
    }
    
    /**
     * read and read share read lock
     * @param service
     */
    public static void multiRead(ReadWriteService service) {
        Thread[] threads = new Thread[new Random().nextInt(9) + 1];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ReadTask(service));
            threads[i].setName("Thread-R" + String.valueOf(i + 1));
        }
        
        for (Thread thread : threads) {
            thread.start();
        }
    }
    
    /**
     * write and write exclusive write lock
     * @param service
     */
    public static void multiWrite(ReadWriteService service) {
        Thread[] threads = new Thread[new Random().nextInt(9) + 1];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new WriteTask(service));
            threads[i].setName("Thread-W" + String.valueOf(i + 1));
        }
        
        for (Thread thread : threads) {
            thread.start();
        }
    }
    
    /**
     * read and write exclusive lock
     * @param service
     */
    public static void multiReadWrite(ReadWriteService service) {
        Thread[] threads = new Thread[new Random().nextInt(15) + 1];
        Random random = new Random();
        
        int readCount = 1;
        int writeCount = 1;
        for (int i = 0; i < threads.length; i++) {
            if (random.nextBoolean()) {
                threads[i] = new Thread(new ReadTask(service));
                threads[i].setName("Thread-R" + String.valueOf(readCount++));
            } else {
                threads[i] = new Thread(new WriteTask(service));
                threads[i].setName("Thread-W" + String.valueOf(writeCount++));
            }
        }
        
        for (Thread thread : threads) {
            thread.start();
        }
    }

}
