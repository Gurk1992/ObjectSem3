/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;

/**
 *
 * @author oscar
 */
public class Accounting {
    private int balance;
    public Accounting(){
        
    }
    
    public void uppdateAccounting(int balance){
        this.balance = balance;
        
    }
}
