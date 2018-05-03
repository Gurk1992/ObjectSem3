/*
 * -------------DONE------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;

import org.junit.Test;
import static org.junit.Assert.*;

import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemRegistry;
import se.kth.iv1350.pos.integration.Inventory;
import se.kth.iv1350.pos.integration.Accounting;


/**
 *
 * @author oscar
 */
public class ReceiptTest {
    
    /**
     * Test of createReceiptString method, of class Receipt.
     */
    @Test
    public void testCreateReceiptString() {
        ItemRegistry itemRegistry = new ItemRegistry();
        Inventory inventory = new Inventory(); 
        Accounting accounting = new Accounting();
        CashRegister cashRegister = new CashRegister(accounting);
        int payment = 20;
        CashPayment cashPayment = new CashPayment(payment, cashRegister);
        ItemDTO itemDTO = new ItemDTO(1, 1, 10);
        Sale sale = new Sale(itemRegistry, inventory);
        SaleInfo saleInfo = sale.registerItem(itemDTO);
        
        saleInfo.recordSaleInfo(itemDTO);
        sale.pay(cashPayment);
       
        Receipt instance = new Receipt(saleInfo);
  
        String expResult = "Sale\n\n" + "Sold ItemID: " + saleInfo.currentItemDTO().getItemID() + "\nCost: " 
                           + saleInfo.getRunningTotal()
                           + "\nChange: " + saleInfo.ammountofChange() + "\n\n";
        
        
        String result = instance.createReceiptString(); 
       
        assertTrue("Wrong printout.", result.contains(expResult));
        assertTrue("Wrong receipt content.", result.contains(expResult));
    }
    
}
