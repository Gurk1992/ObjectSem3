/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.view;

/**
 *Class that handels all error messages and represents them for the user.
 * 
 */
public class ErrorMessageHandler {
    
    void showErrorMsg(String msg){
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("Error: ");
        errorMsg.append(msg);
        System.out.println(errorMsg);
        
    }
}
