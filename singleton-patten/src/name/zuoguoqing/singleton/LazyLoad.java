/**
 * 
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class LazyLoad {
    private static LazyLoad instance;
    private LazyLoad() {
        
    }

    // unsafe in multithread
    public static Object getInstance() {
        if (instance == null) {
            // do other initialize work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // initialize 'instance'
            instance = new LazyLoad();
        }
        
        return instance;
    }
}
