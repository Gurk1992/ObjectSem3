/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;

/**
 *
 * The Class that handels calls with the external Accounting system. Not
 * implemented, but recives info that the class needs.
 */
public class Accounting {
    private int balance;
    public Accounting(){
        
    }
    
    public void uppdateAccounting(int balance){
        this.balance = balance;
        
    }
}
