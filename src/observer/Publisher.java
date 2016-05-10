package observer;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csd-03
 */
public class Publisher implements IPublisher{
        public ArrayList<IObserver> observers=new ArrayList<IObserver>();

    @Override
    public void add(IObserver obs) {
        observers.add(obs);
    }

    @Override
    public void remove(IObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers(boolean status) {
        for(IObserver o : observers){
            o.update(status);
        }
    }
        
        
}
