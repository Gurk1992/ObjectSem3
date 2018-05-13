/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.CashPayment;
import se.kth.iv1350.pos.model.SaleObserver;

/**
 *Show total amount paid for purchases since the program started.
 */
public class TotalRevenueView implements SaleObserver {
    private int totalRevenue;
    private int salesMade;
    
    public TotalRevenueView()
    {
        totalRevenue = 0;
    }
    @Override
    public void newPayment(CashPayment payment)
    {
        addNewSale(payment);
        printCurrentState();
    }
    

    private void addNewSale(CashPayment payment) {
        totalRevenue = payment.getPaidAmmount();
        salesMade++;
    }
    private void printCurrentState(){
        System.out.println("We have now made: "+ salesMade +" Sales");
        System.out.println("TotalRevenue: "+totalRevenue);
    }
}

