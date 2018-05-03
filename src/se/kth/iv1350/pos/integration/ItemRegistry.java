/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;
import java.util.ArrayList;
import java.util.List;


/**
 * Contains all the calls to the data store with items.
 */
public class ItemRegistry {
    private List<ItemDTO> items = new ArrayList<>();
    public ItemRegistry(){
        addItems();
    }    
    /**
     * Checks if searched itemDTO is infact part of the stores item selection.
     *@param searchedItem   The specific item to search for.
     * @return founditem if item was found, else throw exception.
     */
    public ItemDTO findItem(ItemDTO searchedItem){
        for (ItemDTO foundItem : items){
            if(searchedItem.getItemID() == foundItem.getItemID())
                    return foundItem;
        }
        throw new ItemRegistryException("No such Item was found in database: " + searchedItem);
    }
    private void addItems(){
        items.add(new ItemDTO(1, 1, 10));
        items.add(new ItemDTO(2, 1, 20));
        items.add(new ItemDTO(3, 1, 30));
        
    }
}
