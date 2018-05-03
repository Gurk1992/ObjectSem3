/*
 * -------------DONE------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oscar
 */
public class ItemRegistryTest {
     
    /**
     * Test of findItem method, of class ItemRegistry.
     */
    @Test
    public void testFindItem() {
        
        ItemDTO searchedItem = new ItemDTO(1, 1, 10);
        ItemRegistry instance = new ItemRegistry();
        int expResult = searchedItem.getItemID();
        int result = instance.findItem(searchedItem).getItemID();
        assertEquals("Item was found ", expResult, result);
    }
    
     /**
     * Test of findItem method, of class ItemRegistry.
     */
   
    
    @Test(expected = ItemRegistryException.class)
    public void testFindItemOutofBound() {
        
        ItemDTO searchedItem = new ItemDTO(4, 1, 10);
        ItemRegistry instance = new ItemRegistry();
        int expResult = 4;
        int result = instance.findItem(searchedItem).getItemID();
        assertEquals("Item was found not found ", expResult, result);
       
        
    }
    
}
