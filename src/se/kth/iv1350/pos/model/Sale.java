/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.integration.ItemRegistry;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.integration.Inventory;


/**
 * represents one particualar sale.
 */
public class Sale {
    private ItemRegistry itemRegistry;
    private SaleInfo currentSaleInfo;
    private CashPayment payment;
    private Inventory inventory;
    /**
     * Creates one new instance of a particular sale.
     * 
     * @param itemRegistry the datastore containing info about items in the Db.
     * @param inventory the implemented class that talks to external inventory program.
     **/
   public Sale(ItemRegistry itemRegistry, Inventory inventory){
       this.itemRegistry = itemRegistry;
       this.inventory = inventory;
   }
    /**
     *  Registers searched item if it is found in DB
     * 
     * @param searchedItem the particular item that is being searched.
     * @return info about current sale
     **/
    public SaleInfo registerItem(ItemDTO searchedItem){
      ItemDTO foundItem = searchForItem(searchedItem);
      recordItem(foundItem);
      return currentSaleInfo;
    }
    /**
     * Registers totalCost of current sale in payment and uppdates inventory.
     * 
     * @param payment The specifc payment made by the customer.
     **/
    public void pay(CashPayment payment){
        payment.getTotalPrice(currentSaleInfo);
        this.payment = payment;  
        this.inventory.uppdateInventory(currentSaleInfo);
    }
    /**
     * Creates and prints out recipe.
     * 
     * @param printer
     **/
    public void printReceipt(Printer printer){
        Receipt receipt = new Receipt(this.currentSaleInfo);
        printer.printReceipt(receipt);
    }
    
    public CashPayment getPayment(){
        return this.payment;
    }
    /**
     *  Searches the ItemDB for a matching Item.
     * 
     * @param searchedItem the specific item searched for!
     * @return The matching Item from itemDB with the same ID.
     */
    private ItemDTO searchForItem(ItemDTO searchedItem){
        return itemRegistry.findItem(searchedItem);
    }
    /**
     * Records the found item inside currentSaleInfo.
     **/
    private void recordItem(ItemDTO foundItem){
        currentSaleInfo = new SaleInfo(foundItem, this);
        currentSaleInfo.recordSaleInfo(foundItem);
    }
}
