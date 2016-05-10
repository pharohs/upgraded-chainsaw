/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartbeater.application;

import java.util.logging.Level;
import java.util.logging.Logger;
import observer.IPublisher;
/**
 *
 * @author csd-03
 */
abstract public class TimedEvent {
    public IPublisher p;
    public int numOfMilliseconds=1000;
    TimedEvent(IPublisher p){
        this.p=p;
    }
    abstract public void run();
    public void start(){
        try {
            run();
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimedEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
