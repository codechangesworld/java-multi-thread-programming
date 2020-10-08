/**
 * 
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class InstantLoad {
    @SuppressWarnings("unused")
    private int id;
    private String name;
    
    private static InstantLoad instance = new InstantLoad();
    
    private InstantLoad() {
        id = 0;
        name = "InstantLoad";
    }
    
    public String getName() {
        return name;
    }
    
    public static Object getInstance() {
        return instance;
    }
}
