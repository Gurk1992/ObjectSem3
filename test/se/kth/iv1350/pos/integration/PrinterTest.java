/*
 * -------------DONE------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.pos.model.CashPayment;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleInfo;

/**
 *
 * 
 */
public class PrinterTest {
    
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    @Before
    public void setUpStreams() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);
    }
    /**
     * Test of printReceipt method, of class Printer.
     */
   @Test
    public void testCreateReceiptString() {
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
       
        Receipt receipt = new Receipt(saleInfo);
  
        Printer instance = new Printer();
        instance.printReceipt(receipt);
        String expResult = "Sale Receipt\n\n" + "Sold ItemID: " + saleInfo.currentItemDTO().getItemID() + "\nCost: " 
                           + saleInfo.getRunningTotal()
                           + "\nChange: " + saleInfo.ammountofChange() + "\n\n";
        
        String result = outContent.toString();
        
        assertTrue("Wrong printout.", result.contains(expResult));
        assertTrue("Wrong receipt content.", result.contains(expResult));
    }
    
}
