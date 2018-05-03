/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.model.SaleInfo;
/**
 *The hard coded view, placeholder of the view.
 * 
 */
public class View {
    
    private Controller contr;
    /**
     * Creates a new instance.
     *
     * @param contr The controller that is used for all operations.
     */
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * Represents the interface of the program.
     * 
     **/
     public void sampleExecution() {
        ItemDTO searchedItem = new ItemDTO(1, 1, 0);
        contr.startSale();
        SaleInfo saleInfo = contr.searchEnteredItem(searchedItem);
        System.out.println("The total price is: "+saleInfo.getRunningTotal() +"and the price of scanned item is: "+saleInfo.getcurrentItemPrice());
        SaleInfo endSaleInfo = contr.endSale();
        System.out.println("The final price is: "+endSaleInfo.getRunningTotal());
        int paidAmmount = 20;
        contr.pay( paidAmmount);
    }
}
