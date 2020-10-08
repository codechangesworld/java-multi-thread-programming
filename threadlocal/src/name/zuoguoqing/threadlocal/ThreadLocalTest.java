/**
 * 
 */
package name.zuoguoqing.threadlocal;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import name.zuoguoqing.util.ThreadLocalTool;

/**
 * @author zuoguoqing
 *
 */
public class ThreadLocalTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

//         noInitialValue();

//         withInitialValue();

//         noInitialValueIn();

        withInitialValueIn();

    }

    /**
     * no initial value of ThreadLocal object
     */
    public static void noInitialValue() {
        Thread[] threads = new Thread[new Random().nextInt(10) + 1];
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new Task(), "Thread-X" + String.valueOf(i + 1));

                Thread.sleep(1000);

                threads[i].start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * with initial value of ThreadLocal object
     */
    public static void withInitialValue() {
        Thread[] threads = new Thread[new Random().nextInt(10) + 1];
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new TaskExt(), "Thread-X" + String.valueOf(i + 1));

                Thread.sleep(1000);

                threads[i].start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * no initial value of InheritableThreadLocal object
     */
    public static void noInitialValueIn() {
        ThreadLocalTool
                .setInheritable(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(Thread.currentThread().getName() + "\t"
                + ThreadLocalTool.getInheritable().toString());

        Thread[] threads = new Thread[new Random().nextInt(10) + 1];
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new TaskIn(), "Thread-X" + String.valueOf(i + 1));

                Thread.sleep(1000);

                threads[i].start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * with initial value of InheritableThreadLocal object
     */
    public static void withInitialValueIn() {
        System.out.println(Thread.currentThread().getName() + "\t"
                + ThreadLocalTool.getInheritableExt().toString());

        Thread[] threads = new Thread[new Random().nextInt(10) + 1];
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new TaskInExt(), "Thread-X" + String.valueOf(i + 1));

                Thread.sleep(1000);

                threads[i].start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    if (ThreadLocalTool.get() == null) {
                        System.out.println(Thread.currentThread().getName() + "\tno initial value");
                        ThreadLocalTool.set(
                                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

                    }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "\t"
                            + ThreadLocalTool.get().toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static class TaskExt implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    if (ThreadLocalTool.getExt() == null) {
                        System.out.println(Thread.currentThread().getName() + "\tno initial value");
                        ThreadLocalTool.setExt(
                                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

                    }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "\t"
                            + ThreadLocalTool.getExt().toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static class TaskIn implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    if (ThreadLocalTool.getInheritable() == null) {
                        System.out.println(Thread.currentThread().getName() + "\tno initial value");
                        ThreadLocalTool.setInheritable(
                                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

                    }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "\t"
                            + ThreadLocalTool.getInheritable().toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static class TaskInExt implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    if (ThreadLocalTool.getInheritableExt() == null) {
                        System.out.println(Thread.currentThread().getName() + "\tno initial value");
                        ThreadLocalTool.setInheritableExt(
                                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

                    }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "\t"
                            + ThreadLocalTool.getInheritableExt().toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
