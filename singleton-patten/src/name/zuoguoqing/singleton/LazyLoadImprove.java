/**
 * 
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class LazyLoadImprove {
    private static Object instance;

    // low efficiency
    synchronized public static Object getInstance() {
        if (instance == null) {
            
            // do other initialize work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // initialize 'instance'
            instance = new Object();
        }

        return instance;
    }
}
