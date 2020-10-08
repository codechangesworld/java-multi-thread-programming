/**
 * 
 */
package name.zuoguoqing.task;

import name.zuoguoqing.service.Producer;

/**
 * @author zuoguoqing
 *
 */
public class ProduceTask implements Runnable {
    private Producer producer;
    
    /**
     * 
     */
    public ProduceTask(Producer producer) {
        this.producer = producer;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\tstarting produce...");
        
        while (!Thread.interrupted()) {
            producer.produce();
        }
    }

}
