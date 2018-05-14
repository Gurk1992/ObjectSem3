/*---- DONE---
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;

import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemRegistry;
import se.kth.iv1350.pos.integration.Accounting;
import se.kth.iv1350.pos.integration.Inventory;

/**
 *
 * @author oscar
 */
public class SaleTest {
    
    /**
     * Test of registerItem method, of class Sale.
     */
    @Test
    public void testRegisterItem() {
        
        ItemDTO searchedItem = new ItemDTO(1,1,10);
        ItemRegistry itemRegistry = new ItemRegistry();
        Sale instance = new Sale(null);
        SaleInfo saleInfo = new SaleInfo(searchedItem, instance);
        
        instance.registerItem(searchedItem);
        int expResult = 1;
        int result = instance.registerItem(searchedItem).currentItemDTO().getItemID();
        assertEquals(expResult, result);
       
    }
    @Test
    public void testRegisterItemNotSamePrice() {
        
        ItemDTO searchedItem = new ItemDTO(1,1,30);
        ItemRegistry itemRegistry = new ItemRegistry();
        Sale instance = new Sale(null);
        SaleInfo saleInfo = new SaleInfo(searchedItem, instance);
        
        instance.registerItem(searchedItem);
        int expResult = 1;
        int result = instance.registerItem(searchedItem).currentItemDTO().getItemID();
        assertEquals(expResult, result);
       
    }
    /**
     * Test of pay method, of class Sale.
     */
    @Test
    public void testPay() {
        System.out.println("pay");
        Accounting accounting = new Accounting();
        CashRegister cashRegister = new CashRegister(accounting);
        CashPayment payment = new CashPayment(20, cashRegister);
        ItemRegistry itemRegistry = new ItemRegistry();
        Inventory inventory = new Inventory();
        Sale instance = new Sale(inventory );
        ItemDTO itemDTO = new ItemDTO(1,1,10);
        instance.registerItem(itemDTO);
        instance.pay(payment);
        int expResult = 20;
        int result = instance.getPayment().getPaidAmmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of printReceipt method, of class Sale.
     */
    @Test
    public void testPrintReceipt() {
        Inventory inventory = new Inventory(); 
        Accounting accounting = new Accounting();
        CashRegister cashRegister = new CashRegister(accounting);
        int payment = 20;
        CashPayment cashPayment = new CashPayment(payment, cashRegister);
        ItemDTO itemDTO = new ItemDTO(1, 1, 10);
        Sale sale = new Sale(inventory);
        SaleInfo saleInfo = sale.registerItem(itemDTO);
        
        saleInfo.recordSaleInfo(itemDTO);
        sale.pay(cashPayment);
       
        Receipt instance = new Receipt(saleInfo);
  
        String expResult = "Sale Receipt\n\n" + "Sold ItemID: " + saleInfo.currentItemDTO().getItemID() + "\nCost: " 
                           + saleInfo.getRunningTotal()
                           + "\nChange: " + saleInfo.ammountofChange() + "\n\n";
        
        
        String result = instance.createReceiptString(); 
        System.out.println(result);
        System.out.println(expResult);
        assertTrue("Wrong printout.", result.contains(expResult));
        assertTrue("Wrong receipt content.", result.contains(expResult));
    }
}
