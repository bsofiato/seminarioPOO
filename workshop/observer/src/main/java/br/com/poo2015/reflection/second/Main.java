/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poo2015.reflection.second;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {
    public static void main(String [] args) throws Exception {
        MyBean bean = PropertyChangeObservableFactory.newObservableInstance(MyBean.class);
        ((PropertyChangeObservable)(bean)).addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt);
            }
        
        });
        bean.setIdade(23);
        bean.setIdade(12);
    }
}
