/**
 * 
 */
package name.zuoguoqing.test;

/**
 * @author zuoguoqing
 *
 */

/*
 * VM Args: -Xss2M
 */
public class JavaVMStackOOM {

    private void donotstop() {
        while(true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> donotstop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
