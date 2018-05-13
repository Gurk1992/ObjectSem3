/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;

/**
 *A listerner interface that recives info about Sales
 * 
 */
public interface SaleObserver {
    /**
     *Called when payment has been made.
     * @param payment that has been made
     **/
    void newPayment(CashPayment payment);
}
