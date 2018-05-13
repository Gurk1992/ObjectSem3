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
    private CashPayment cashPayment;
    private SaleObserver saleObserver;
    
   public CashRegister(Accounting accounting){
       this.accounting = accounting;
   }
    /**
     * Uppdates balance to pass along to accounting.
     * 
     * @param payment is the CashPayment, which contains totalammount and paidammount
     **/
    public void addPayment(CashPayment payment) {
        this.cashPayment = payment;
        this.balance = balance + (payment.getTotalCost());
        this.accounting.uppdateAccounting(this.balance);
        notifyObservers();
    }
    /**
     * Notifies observers about info.
     **/
    private void notifyObservers(){
            this.saleObserver.newPayment(cashPayment);
        }
    /**
     * adds observer to list
     * @param obs Observer to add.
     **/
    public void addSaleObserver(SaleObserver obs){
        this.saleObserver = obs;
    }
}
    