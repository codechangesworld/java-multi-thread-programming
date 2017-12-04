/**
 * 
 */
package name.zuoguoqing.task;

import name.zuoguoqing.service.ReadWriteService;

/**
 * @author zuoguoqing
 *
 */
public class WriteTask implements Runnable {
    
    private ReadWriteService service;
    
    public WriteTask(ReadWriteService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
    
}
