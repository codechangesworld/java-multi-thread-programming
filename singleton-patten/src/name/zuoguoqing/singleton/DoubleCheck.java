/**
 * 
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class DoubleCheck {
    volatile private static DoubleCheck instance;
    private DoubleCheck() {
        
    }
    
    
    public static DoubleCheck getInstance() {
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
                    instance = new DoubleCheck();
                }
            }
        }
        
        return instance;
    }
}
