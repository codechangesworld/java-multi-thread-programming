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
public class ThreadLocalExt extends ThreadLocal<Object> {
    
    @Override
    protected Object initialValue() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
