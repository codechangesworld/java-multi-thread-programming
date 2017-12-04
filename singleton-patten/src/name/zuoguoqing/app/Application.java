/**
 * 
 */
package name.zuoguoqing.app;

import java.util.Random;

import name.zuoguoqing.singleton.DoubleCheck;
import name.zuoguoqing.singleton.InstantLoad;
import name.zuoguoqing.singleton.LazyLoad;
import name.zuoguoqing.singleton.LazyLoadImprove;

/**
 * @author zuoguoqing
 *
 */
public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // instantLoad();

        // lazyLoad();

        // lazyLoadImprove();

        doubleCheck();

    }

    public static void singletonTest(Runnable task) {
        Thread[] threads = new Thread[new Random().nextInt(10) + 1];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].setName("Thread-" + String.valueOf(i + 1));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    // right and too simple
    public static void instantLoad() {
        Runnable task = () -> {
            Object instance = InstantLoad.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t" + instance);
        };

        singletonTest(task);
    }

    // multithread unsafe
    public static void lazyLoad() {
        Runnable task = () -> {
            Object instance = LazyLoad.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t" + instance);
        };

        singletonTest(task);
    }

    // right and low efficiency
    public static void lazyLoadImprove() {
        Runnable task = () -> {
            Object instance = LazyLoadImprove.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t" + instance);
        };

        singletonTest(task);
    }

    // right and efficiency
    public static void doubleCheck() {
        Runnable task = () -> {
            Object instance = DoubleCheck.getInstance();
            System.out.println(Thread.currentThread().getName() + "\t" + instance);
        };

        singletonTest(task);
    }

}
