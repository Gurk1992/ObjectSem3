/*---- DONE---
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;


import org.junit.Test;
import static org.junit.Assert.*;

import se.kth.iv1350.pos.integration.Inventory;
import se.kth.iv1350.pos.integration.ItemRegistry;
import se.kth.iv1350.pos.integration.ItemDTO;

/**
 *
 * @author oscar
 */
public class SaleInfoTest {
       /**
     * Test of recordSaleInfo method, of class SaleInfo.
     */
    @Test
    public void testRecordSaleInfo() {
  
        Inventory inventory = new Inventory();
        ItemDTO foundItem = new ItemDTO(1 ,1 ,10 );
        Sale sale = new Sale(inventory);
        SaleInfo instance = new SaleInfo(foundItem, sale);
        int expResult = 10;
        int result = instance.recordSaleInfo(foundItem).getcurrentItemPrice();
        assertEquals(expResult, result);
      
    }
 }