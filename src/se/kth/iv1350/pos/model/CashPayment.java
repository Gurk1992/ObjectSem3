/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;


/**
 * Represent one specific cash payment for a specific sale.
 * 
 */
public class CashPayment {
   private int paidAmmount;
   private int TotalCost; 
 
    public CashPayment(int paidAmmount, CashRegister cashRegister){
        this.paidAmmount = paidAmmount;
    }
    
    //Change name to SetTotalPrice.
    public void getTotalPrice(SaleInfo paidSaleInfo){
      this.TotalCost=  paidSaleInfo.getRunningTotal();
    }
    public int getTotalCost(){
        return this.TotalCost;
    }
    public int getPaidAmmount(){
        return this.paidAmmount;
    }
}