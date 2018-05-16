/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.util;
/**
 *
 * @author oscar
 */
public class ConsoleLogger implements Logger{
    /**
     * Prints out specific string to user.
     * 
     * @param message
     **/
    @Override
    public void log(String message){
        System.out.println(message);
    }
    
}
