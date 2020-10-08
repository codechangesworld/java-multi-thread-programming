/**
 * @description 
 * 
 * @author zuoguoqing
 * @date 2020年10月8日
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class StaticCodeBlock {
    @SuppressWarnings("unused")
    private int id;
    private String name;
    
    private static StaticCodeBlock instance;
    
    private StaticCodeBlock() {
        id = 0;
        name = "StaticCodeBlock";
    }
    
    // 静态代码块在类加载时已经进行初始化
    static {
        instance = new StaticCodeBlock();
    }
    
    public String getName() {
        return name;
    }
    
    public static StaticCodeBlock getInstance() {
        return instance;
    }

}
