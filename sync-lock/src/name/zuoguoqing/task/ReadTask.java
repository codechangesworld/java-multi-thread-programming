/**
 * 
 */
package name.zuoguoqing.task;

import name.zuoguoqing.service.ReadWriteService;

/**
 * @author zuoguoqing
 *
 */
public class ReadTask implements Runnable {
    
    private ReadWriteService service;
    
    public ReadTask(ReadWriteService service) {
        super();
        this.service = service;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        service.read();
    }

}
