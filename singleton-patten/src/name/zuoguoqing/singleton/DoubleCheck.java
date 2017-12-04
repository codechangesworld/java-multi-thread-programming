/**
 * 
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class DoubleCheck {
    volatile private static Object instance;
    
    
    public static Object getInstance() {
        if (instance == null) {
            // do other initialize work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // initialize 'instance'
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new Object();
                }
            }
        }
        
        return instance;
    }
}
