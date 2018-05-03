/* DONT KNOW HOW TO TEST.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;


import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.pos.integration.Accounting;
import se.kth.iv1350.pos.model.CashPayment;

/**
 *
 * @author oscar
 */
public class CashRegisterTest {
    
    /**
     * Test of addPayment method, of class CashRegister.
     */
    @Test
    public void testAddPayment() {
        Accounting accounting = new Accounting();
        CashRegister instance = new CashRegister(accounting);
        CashPayment payment = new CashPayment(20, instance);
        
        instance.addPayment(payment);
    }  
}
