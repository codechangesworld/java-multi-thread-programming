/**
 * 
 */
package name.zuoguoqing.concurrent;

/**
 * @author zuoguoqing
 *
 */
public class JoinThread {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // not use join
        // commonNotJoin();

        // use join
         commonJoin();

        // timed join
//        commonTimedJoin();
    }

    /**
     * not use join
     */
    public static void commonNotJoin() {
        Thread thread = new Thread(new Task(), "Thread-001");
        thread.start();

        System.out.println(Thread.currentThread().getName() + "\tthis is main thread!");
    }

    /**
     * use join
     */
    public static void commonJoin() {
        Thread thread = new Thread(new Task(), "Thread-001");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // this will run until 'thread' object terminated
        System.out.println(Thread.currentThread().getName() + "\tthis is main thread!");
    }

    /**
     * use join(long)
     */
    public static void commonTimedJoin() {
        Thread thread = new Thread(new Task(), "Thread-001");
        thread.start();
        try {
            /*
             * notice: 
             * join(long) method use wait(long) to block current thread,
             * therefore it will release the monitor on 'thread' object
             * when it is wait(long).
             */
            thread.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // this will run before 'thread' terminated 
        // because join time is smaller than 'thread' run time
        System.out.println(Thread.currentThread().getName() + "\tthis is main thread!");
    }

    // ============================================================================================

    /**
     * test task
     * 
     * @author zuoguoqing
     *
     */
    private static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "\tstart");

            // do some work
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "\tterminated");
        }

    }
}
