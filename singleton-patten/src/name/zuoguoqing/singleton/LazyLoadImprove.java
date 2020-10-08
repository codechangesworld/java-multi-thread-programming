/**
 * 
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class LazyLoadImprove {
    private static LazyLoadImprove instance;
    private LazyLoadImprove() {
        
    }

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
            instance = new LazyLoadImprove();
        }

        return instance;
    }
}
