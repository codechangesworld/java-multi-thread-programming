package name.zuoguoqing.concurrent;

public class RunThread {
    
    /**
     * 
     * @author zuoguoqing
     *
     */
    static class Thread1 extends Thread {
        
        Thread1(String name) {
            super(name);
        }
        
        @Override
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
    }
    
    /**
     * 
     * @author zuoguoqing
     *
     */
    static class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable thread is running!");
        }
        
    }
    
    /**
     * 
     * @author zuoguoqing
     *
     */
    static class Thread3 extends Thread {

        @Override
        public void run() {
            System.out.println("run:" + this.isAlive());
        }
        
    }
    
    /**
     *中断测试
     * @author zuoguoqing
     *
     */
    static class Thread4 extends Thread {
        @Override
        public void run() {
            while (!this.isInterrupted()) {
                System.out.println("interrupted status: " + Thread.interrupted());
            }
            System.out.println("final interrupted status: " + this.isInterrupted());
        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1("My Thread1");
        thread1.start();
        Thread thread2 = new Thread(new Thread2(), "RunnableThread");
        thread2.start();
        
        Thread3 thread3 = new Thread3();
        System.out.println("begin: " + thread3.isAlive());
        thread3.start();
        Thread.sleep(1000);
        System.out.println("end: " + thread3.isAlive());
        
        Thread4 thread4 = new Thread4();
        thread4.start();
        Thread.sleep(5);
        thread4.interrupt();
        
        
//        System.out.println(Thread.currentThread().getName() + " stop!");
//        System.exit(0);
    }

}
