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
public class Observer implements IObserver {
    private String name;
    public Observer(String name){
        this.name=name;
    }
    @Override
    public void update(String message) {
        System.out.println(this.name +" has been updated with status "+status);
    }
    

}
