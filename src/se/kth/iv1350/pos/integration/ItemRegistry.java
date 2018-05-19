/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.pos.util.Logger;


/**
 * Contains all the calls to the data store with items.
 */
public class ItemRegistry {
    
    private List<ItemDTO> items = new ArrayList<>();
    private static final ItemRegistry ITEMREGISTRY = new ItemRegistry();
        
    public static ItemRegistry getRegistry(){
        ITEMREGISTRY.addItems();
        return ITEMREGISTRY;
    }
    /**
     * Checks if searched itemDTO is infact part of the stores item selection.
     *@param searchedItem   The specific item to search for.
     * @return founditem if item was found, else throw exception.
     * @throws ItemRegistryException, if the item does not exist.
     * @throws DatabaseFailureException if the database fails (when ItemID =5).
     */
    public ItemDTO findItem(ItemDTO searchedItem) throws ItemRegistryException, DatabaseFailureException{
        
        for (ItemDTO foundItem : items){
            if (searchedItem.getItemID() == 5)
                throw new DatabaseFailureException("The database is currently busy. Please try again.");
            if(searchedItem.getItemID() == foundItem.getItemID())
                    return foundItem;
        }
        throw new ItemRegistryException("No such Item was found in database: " + searchedItem.getItemID());
        
    }
    private void addItems(){
        items.add(new ItemDTO(1, 1, 10));
        items.add(new ItemDTO(2, 1, 20));
        items.add(new ItemDTO(3, 1, 30));
        
    }
}
