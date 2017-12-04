/**
 * 
 */
package name.zuoguoqing.threadlocal;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zuoguoqing
 *
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal<Object> {
    
    @Override
    protected Object initialValue() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
