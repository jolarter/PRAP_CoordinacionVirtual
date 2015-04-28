/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poli.prap.cv.service.util;

/**
 *
 * @author julianolarte
 */
public class SendEmailSingleton implements Runnable{
    private static SendEmailSingleton instance = null;
    private SendEmailSingleton(){
        new Thread(this).start();
    }
    public static SendEmailSingleton getInstance() {
        if(instance == null){
            instance = new SendEmailSingleton();
        }
        return instance;
    }
    public void run(){
        System.out.println("El hilo está corriendo.");
        while(true){
            //...
        }
    }
}
