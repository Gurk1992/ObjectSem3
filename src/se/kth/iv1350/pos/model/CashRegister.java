/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.integration.Accounting;

/**
 * Represents a cash register. There shall be one instance of this class for
 * each register.
 */
public class CashRegister {
    private int balance;
    private Accounting accounting;
    
   public CashRegister(Accounting accounting){
       this.accounting = accounting;
   }
    
    public void addPayment(CashPayment payment) {
        this.balance = balance + (payment.getTotalCost());
        this.accounting.uppdateAccounting(this.balance);
    }
}