/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.controller;



import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleInfo;
import se.kth.iv1350.pos.model.CashPayment;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.integration.Accounting;
import se.kth.iv1350.pos.integration.DatabaseFailureException;
import se.kth.iv1350.pos.integration.Inventory;
import se.kth.iv1350.pos.integration.ItemRegistry;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.integration.ItemRegistryException;
import se.kth.iv1350.pos.model.TotalRevenueObserver;


/**
 * This is the applications only controller class. All calls to model pass 
 * through here.
**/
public class Controller {
   private TotalRevenueObserver saleObserver;
   private Sale sale;
   private ItemRegistry itemRegistry;
   private SaleInfo currentSaleInfo;
   private Accounting accounting;
   private Inventory inventory;
   private Printer printer;
   
   
    public Controller(Accounting accounting, Inventory inventory, Printer printer) {
        this.itemRegistry = ItemRegistry.getRegistry();
        this.accounting = accounting;
        this.inventory = inventory;
        this.printer = printer;
    }
    
    /**
     * starts the a new sale obejct
     * 
     **/
    public void startSale(){
        sale = new Sale(this.inventory);
        
    }

    /**
     * searches for the entered item
     * 
     * @param searchedItem the scanned item.
     * @return info about current sale
     **/
    public SaleInfo searchEnteredItem(ItemDTO searchedItem)throws ItemRegistryException, DatabaseFailureException{
        
            return currentSaleInfo = sale.registerItem(searchedItem);
    }
    /**
     * Fetches current SaleInfo
     * @return uppdates current SaleInfo
     **/
    public SaleInfo endSale(){
      return currentSaleInfo = currentSaleInfo.fetchSaleInfo(currentSaleInfo);   
    }
    /**
     * Registers payment of current sale.
     * @param paidAmmount ammount of money handed to the cashier
     **/
    public void pay(int paidAmmount){
    CashRegister cashRegister = new CashRegister(this.accounting); 
    cashRegister.addTotalRevenueObserver(saleObserver);
    CashPayment payment = new CashPayment(paidAmmount, cashRegister);
    sale.pay(payment);
    cashRegister.addPayment(payment);
    sale.printReceipt(printer);
    
    
    }
    public void addSaleObserver(TotalRevenueObserver obs){
        this.saleObserver = obs;
    }
}
