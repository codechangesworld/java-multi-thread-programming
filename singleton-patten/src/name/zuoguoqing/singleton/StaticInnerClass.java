/**
 * @description 
 * 
 * @author zuoguoqing
 * @date 2019年4月19日
 */
package name.zuoguoqing.singleton;

/**
 * @author zuoguoqing
 *
 */
public class StaticInnerClass {
    private StaticInnerClass() {

    }

    private static class InnerClass {
        private static StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return InnerClass.instance;
    }
}
