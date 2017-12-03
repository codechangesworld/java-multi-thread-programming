/**
 * 
 */
package name.zuoguoqing.concurrent;

/**
 * @author zuoguoqing
 *
 */
public class DeadLock {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Come into dead lock aero!!!");
        DeadLockService service = new DeadLockService();
        
//        Thread thread1 = new Thread(new DeadLockTask1(service));
//        Thread thread2 = new Thread(new DeadLockTask2(service));
        
        Thread thread1 = new Thread(() -> service.add());
        Thread thread2 = new Thread(() -> service.divide());
        
        thread1.start();
        thread2.start();
    }

    static class DeadLockTask1 implements Runnable {
        private DeadLockService service;
        
        public DeadLockTask1(DeadLockService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.add();
        }
    }
    
    static class DeadLockTask2 implements Runnable {
        private DeadLockService service;
        
        public DeadLockTask2(DeadLockService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.divide();
        }
    }

    static class DeadLockService {
        private Object lock1 = new Object();
        private Object lock2 = new Object();

        public void add() {
            synchronized (lock1) {
                System.out.println("'add' method own lock1");

                // do some work
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("'add' method waiting lock2");
                synchronized (lock2) {

                }
            }
        }

        public void divide() {
            synchronized (lock2) {
                System.out.println("'divide method own lock2'");

                // do some work
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("'divide' method waiting lock1...");
                synchronized (lock1) {

                }
            }
        }
    }

}
