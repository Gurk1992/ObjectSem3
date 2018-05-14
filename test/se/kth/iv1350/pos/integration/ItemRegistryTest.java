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
        ItemRegistry instance = ItemRegistry.getRegistry();
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
        ItemRegistry instance = ItemRegistry.getRegistry();
        int expResult = 4;
        int result = instance.findItem(searchedItem).getItemID();
        assertEquals("Item was found not found ", expResult, result);
       
        
    }
    @Test
    public void testfindItemNotExisting() throws ItemRegistryException {
        ItemDTO searchedItem = new ItemDTO(8, 1, 10);
        ItemRegistry instance = ItemRegistry.getRegistry();
        try{
            instance.findItem(searchedItem);
            fail("No such Item was found in database: " + searchedItem);
        }
        catch(ItemRegistryException exc){
            assertTrue("Wrong Exception message, does not " + " contain itemID: " 
                    + exc.getMessage(), 
                    exc.getMessage().contains(searchedItem.toString()) );
        }
            
    }
    
}
