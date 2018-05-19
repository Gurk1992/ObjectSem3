/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.view;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.ItemDTO;
import se.kth.iv1350.pos.model.SaleInfo;
import se.kth.iv1350.pos.integration.ItemRegistryException;
import se.kth.iv1350.pos.integration.DatabaseFailureException;
import se.kth.iv1350.pos.util.ConsoleLogger;
import se.kth.iv1350.pos.util.FileLogger;
import se.kth.iv1350.pos.util.Logger;

/**
 *The hard coded view, placeholder of the view.
 * 
 */
public class View {
    
    private SaleInfo saleInfo;
    private Controller contr;
    private Logger logger;
    
    private void setLogger(Logger logger){
        this.logger = logger;
    }
    
    /**
     * Creates a new view instance.
     *
     * @param contr The controller that is used for all operations.
     * 
     */
    public View(Controller contr){
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueView());
    }
    /**
     * Represents the interface of the program.
     * 
     **/
     public void sampleExecution(){
       
        ItemDTO searchedItem = new ItemDTO(3, 1, 0);
        try{
            contr.startSale();
            
            this.saleInfo = contr.searchEnteredItem(searchedItem);
            //System.out.println("The total price is: "+saleInfo.getRunningTotal() +"\nScanned item price is: "+saleInfo.getcurrentItemPrice());
            SaleInfo endSaleInfo = contr.endSale();
            //System.out.println("The final price is: "+endSaleInfo.getRunningTotal()+"\n");
            int paidAmmount = 20;
            contr.pay( paidAmmount);
            }
        catch(DatabaseFailureException DatabaseExc)
        {
            setLogger(new FileLogger());
            logger.log(DatabaseExc.getMessage());
            setLogger(new ConsoleLogger());
            logger.log("System crashed try again!");
            
      
        }
        catch(ItemRegistryException ItemRegExc){
            setLogger(new ConsoleLogger());
            logger.log(ItemRegExc.getLocalizedMessage());
            setLogger(new FileLogger());
            logger.log(ItemRegExc.getLocalizedMessage());
        }
    }
     
     
}
