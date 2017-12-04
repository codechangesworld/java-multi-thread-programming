/**
 * 
 */
package name.zuoguoqing.util;

import name.zuoguoqing.threadlocal.InheritableThreadLocalExt;
import name.zuoguoqing.threadlocal.ThreadLocalExt;

/**
 * @author zuoguoqing
 *
 */
public class ThreadLocalTool {
    private final static ThreadLocal<Object> VALUES = new ThreadLocal<>();
    private final static ThreadLocalExt EXT_VALUES = new ThreadLocalExt();
    private final static InheritableThreadLocal<Object> INHERITABLE_VALUES = new InheritableThreadLocal<>();
    private final static InheritableThreadLocalExt EXT_INHERITABLE_VALUES = new InheritableThreadLocalExt();

    public static void set(Object value) {
        VALUES.set(value);
    }

    public static Object get() {
        return VALUES.get();
    }

    public static void setExt(Object value) {
        EXT_VALUES.set(value);
    }

    public static Object getExt() {
        return EXT_VALUES.get();
    }
    
    public static void setInheritable(Object value) {
        INHERITABLE_VALUES.set(value);
    }
    
    public static Object getInheritable() {
        return INHERITABLE_VALUES.get();
    }
    
    public static void setInheritableExt(Object value) {
        EXT_INHERITABLE_VALUES.set(value);
    }
    
    public static Object getInheritableExt() {
        return EXT_INHERITABLE_VALUES.get();
    }
}
