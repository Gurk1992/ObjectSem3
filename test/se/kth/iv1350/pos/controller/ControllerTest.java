/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.model.SaleInfo;
import se.kth.iv1350.pos.integration.Accounting;
import se.kth.iv1350.pos.integration.Inventory;
import se.kth.iv1350.pos.integration.ItemRegistry;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.model.CashPayment;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.Sale;

/**
 *
 * @author oscar
 */
public class ControllerTest {
    private Controller instance;
    private ItemRegistry itemRegistry;
    private SaleInfo saleInfo;
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    
   
    
    @Before
    public void setUp() {
        
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Printer printer = new Printer();
        Inventory inventory = new Inventory();
        Accounting accounting = new Accounting();
        ItemRegistry itemRegistrya = new ItemRegistry();
        
        
        instance = new Controller(accounting, inventory, printer);
    }
    
    @After
    public void tearDown() {
        //outContent = null;
        //System.setOut(originalSysOut);
       // instance = null;
        //itemRegistry = null;
    }
   
    /**
     * Test of searchEnteredItem method, of class Controller.
     */
    @Test
    public void testSearchEnteredItem() {
        this.instance.startSale();
        ItemDTO searchedItem = new ItemDTO(1,1,10);
        this.instance.searchEnteredItem(searchedItem);
        int expResult = searchedItem.getItemID();
        int result = this.instance.searchEnteredItem(searchedItem).currentItemDTO().getItemID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of endSale method, of class Controller.
     */
    @Test
    public void testEndSale() {
        this.instance.startSale();
        ItemDTO searchedItem = new ItemDTO(1,1,10);
       SaleInfo result = (this.saleInfo = this.instance.searchEnteredItem(searchedItem));
       SaleInfo expResult = this.saleInfo;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of pay method, of class Controller.
     */
    @Test
    public void testPay() {
        ItemDTO itemDTO = new ItemDTO(1, 1, 10);
        this.instance.startSale();
        saleInfo = this.instance.searchEnteredItem(itemDTO);
        int paidAmmount = 20;
        this.instance.endSale();
        this.instance.pay(paidAmmount);
    
        String expResult = "Sale Receipt\n\n" + "Sold ItemID: " + 
                             saleInfo.currentItemDTO().getItemID() + "\nCost: " 
                           + saleInfo.getRunningTotal() + "\nChange: " 
                           + saleInfo.ammountofChange() + "\n\n";
        
        String result = outContent.toString();
        
        assertTrue("Wrong printout.", result.contains(expResult));
        assertTrue("Wrong receipt content.", result.contains(expResult));
    }
    
}
