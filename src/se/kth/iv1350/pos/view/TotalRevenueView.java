/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.view;


import se.kth.iv1350.pos.model.TotalRevenueObserver;

/**
 *Show total amount paid for purchases since the program started.
 */
public class TotalRevenueView implements TotalRevenueObserver {
    private int totalRevenue;
    private int salesMade;
    
    public TotalRevenueView()
    {
        totalRevenue = 0;
    }
    @Override
    public void newPayment(int payment)
    {
        addNewpayment(payment);
        printCurrentState();
    }
    

    private void addNewpayment(int payment) {
        totalRevenue = payment; 
        salesMade++;
    }
    private void printCurrentState(){
        System.out.println("We have now made: "+ salesMade +" Sale");
        System.out.println("TotalRevenue: "+totalRevenue +"\n");
    }
}

