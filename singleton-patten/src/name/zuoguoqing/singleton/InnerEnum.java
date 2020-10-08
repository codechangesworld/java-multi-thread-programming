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
public class InnerEnum {
    private InnerEnum() {
        
    }
    
    private enum SingletonEnum {
        SINGLE_VAR;
        
        private InnerEnum localVar;
        private SingletonEnum() {
            this.localVar  = new InnerEnum();
        }
    }
    
    public static InnerEnum getInstance() {
        return SingletonEnum.SINGLE_VAR.localVar;
    }

}
