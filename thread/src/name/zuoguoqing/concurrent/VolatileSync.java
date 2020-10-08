/**
 * Package: name.zuoguoqing.concurrent
 * Author:  zuoguoqing
 * Date:    2020年10月6日
 */
package name.zuoguoqing.concurrent;

/**
 * @author zuoguoqing
 *
 */
public class VolatileSync {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Program starts!");

        SyncService service = new SyncService();
        new Thread(service::getI).start();
        new Thread(service::setI).start();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Program ends!");
        System.exit(0);
    }
    
    static class SyncService {
        private volatile int i = 0;
        
        public void getI() {
            System.out.println("coming into getI");
            try {
                while (true) {
                    System.out.println("get: i = " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        public void setI() {
            System.out.println("coming into setI");
            try {
                while (true) {
                    synchronized (this) {
                        i++;
                    }
                    System.out.println("set: i = " + i);
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
