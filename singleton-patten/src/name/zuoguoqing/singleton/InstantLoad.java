/**
 * 
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class InstantLoad {
    private static Object instance = new Object();
    
    public static Object getInstance() {
        return instance;
    }
}
