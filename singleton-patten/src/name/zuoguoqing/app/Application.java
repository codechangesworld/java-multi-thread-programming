/**
 * 
 */
package name.zuoguoqing.app;

import java.util.Random;

import name.zuoguoqing.singleton.DoubleCheck;
import name.zuoguoqing.singleton.InnerEnum;
import name.zuoguoqing.singleton.InstantLoad;
import name.zuoguoqing.singleton.LazyLoad;
import name.zuoguoqing.singleton.LazyLoadImprove;
import name.zuoguoqing.singleton.StaticCodeBlock;

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

        // doubleCheck();

        staticCodeBlock();

        // innerEnum();

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
            System.out.println(Thread.currentThread().getName() + "\t" + InstantLoad.getInstance());
        };

        singletonTest(task);
    }

    // multithread unsafe
    public static void lazyLoad() {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + "\t" + LazyLoad.getInstance());
        };

        singletonTest(task);
    }

    // right and low efficiency
    public static void lazyLoadImprove() {
        Runnable task = () -> {
            System.out.println(
                    Thread.currentThread().getName() + "\t" + LazyLoadImprove.getInstance());
        };

        singletonTest(task);
    }

    // right and efficiency
    public static void doubleCheck() {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + "\t" + DoubleCheck.getInstance());
        };

        singletonTest(task);
    }

    // static code block
    public static void staticCodeBlock() {
        singletonTest(() -> {
            System.out.println(
                    Thread.currentThread().getName() + "\t" + StaticCodeBlock.getInstance());
        });
    }

    // enum
    public static void innerEnum() {
        singletonTest(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + InnerEnum.getInstance());
        });
    }

}
