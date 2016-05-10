/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartbeater.application;
import observer.IPublisher;
/**
 *
 * @author csd-03
 */
public class CheckServerTimedEvent extends TimedEvent{

    CheckServerTimedEvent(IPublisher p){
        super(p);
    }
    
    @Override
    public void run() {
        HeartListener heartListener=new HeartListener();
        if(heartListener.check()){
            p.notifyObservers("Server is down");
        }        
    }
    
}
