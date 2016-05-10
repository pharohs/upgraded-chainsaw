package observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csd-03
 */
public interface IPublisher {
    public void add(IObserver obs);
    public void remove(IObserver obs);
    public void notifyObservers(String message);
}
