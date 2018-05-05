/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;
import se.kth.iv1350.pos.integration.ItemDTO;


/**
 * Represent info about sale to return back to view.
 * 
 */
public class SaleInfo {
    private int runningTotal;
    private int curentItemPrice;
    private ItemDTO currentItem;   
    private Sale currentSale;
    private int change;
 
    
    /**
     *Creates one particuarl instance of a saleInfo.
     * @param itemDTO the newest item to add into the saleInfo
     * @param sale current sale.
     **/
    public SaleInfo(ItemDTO itemDTO, Sale sale){
        this.currentItem =itemDTO;
        this.currentSale = sale;
        
    }
    /**
     * Stores sale info from scanned item that is acctuly matched with item in DB
     * 
     * @param foundItem The particular itemDTO to store.
     * @return saleInfo about current sale.
     **/
    public SaleInfo recordSaleInfo(ItemDTO foundItem){
        this.runningTotal =+ foundItem.getPrice();
        this.curentItemPrice = foundItem.getPrice();
        
        return this;
    }
    public SaleInfo fetchSaleInfo(SaleInfo CurrentSaleInfo){
        return this;
    }
    public int getRunningTotal (){
        return this.runningTotal;
    }
    public int getcurrentItemPrice (){
        return this.curentItemPrice;
    }
    public ItemDTO currentItemDTO()
    {
        return this.currentItem;
    }
    public int ammountofChange(){
        calculateChange();
        return this.change;
    }
    private void calculateChange(){
        this.change = (currentSale.getPayment().getPaidAmmount())-this.curentItemPrice;
    }
}
