/**
 * 
 */
package name.zuoguoqing.concurrent;

/**
 * @author zuoguoqing
 *
 */
public class ThreadHandler {

    public void dead() {
        System.out.println("Come into dead aero!!!");
        while (true) {
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // new ThreadHandler().dead();

        System.out.println("Program starts...");

        Thread thread1 = new Thread(new ExceptingTask());
        Thread thread2 = new Thread(new ReturnTask());

        thread1.start();
        thread2.start();
        System.out.println("thread1.isAlive: " + thread1.isAlive());
        System.out.println("thread2.isAlive: " + thread2.isAlive());
        System.out.println("thread1.isInterrupted: " + thread1.isInterrupted());
        System.out.println("thread2.isInterrupted: " + thread2.isInterrupted());

         Thread.sleep(500);

        thread1.interrupt();
        thread2.interrupt();

        Thread.sleep(1000);
        System.out.println("after interrupt method");
        System.out.println("thread1.isAlive: " + thread1.isAlive());
        System.out.println("thread2.isAlive: " + thread2.isAlive());
        System.out.println("thread1.isInterrupted: " + thread1.isInterrupted());
        System.out.println("thread2.isInterrupted: " + thread2.isInterrupted());

        System.out.println("Program ends");
    }

    /**
     * interrupt thread by throwing new exception
     * 
     * @author zuoguoqing
     *
     */
    static class ExceptingTask implements Runnable {

        @Override
        public void run() {
            System.out.println("ExceptionTask starts running...");
            try {
                for (int i = 0; i < 1_000; i++) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }

                    // do work here
                     Thread.sleep(500);
//                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                System.out.println("ExceptionTask interruped with exception!");
            }
        }// end run

    }

    /**
     * interrupt thread with return
     * 
     * @author zuoguoqing
     *
     */
    static class ReturnTask implements Runnable {

        @Override
        public void run() {
            System.out.println("ReturnTask starts running...");

            try {
                for (int i = 0; i < 1_000; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("ReturnTask interrupted with return!");
                        return;
                    }

                    // do work here
                    Thread.sleep(1000);
//                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                System.out.println("ReturnTask interrupted with sleep exception!");
            }

        }

    }

}
