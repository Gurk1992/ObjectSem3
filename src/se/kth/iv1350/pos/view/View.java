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
import se.kth.iv1350.pos.util.LogHandler;
import java.io.IOException;
import se.kth.iv1350.pos.integration.DatabaseFailureException;

/**
 *The hard coded view, placeholder of the view.
 * 
 */
public class View {
    
    private SaleInfo saleInfo;
    private Controller contr;
    private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    private LogHandler logger = new LogHandler();
    /**
     * Creates a new view instance.
     *
     * @param contr The controller that is used for all operations.
     */
    public View(Controller contr) throws IOException{
        this.contr = contr;
        contr.addSaleObserver(new TotalRevenueView());
    }
    /**
     * Represents the interface of the program.
     * 
     **/
     public void sampleExecution() {
       
        ItemDTO searchedItem = new ItemDTO(1, 1, 0);
        try{
            contr.startSale();
            
            this.saleInfo = contr.searchEnteredItem(searchedItem);
            System.out.println("The total price is: "+saleInfo.getRunningTotal() +"\nScanned item price is: "+saleInfo.getcurrentItemPrice());
            SaleInfo endSaleInfo = contr.endSale();
            System.out.println("The final price is: "+endSaleInfo.getRunningTotal()+"\n");
            int paidAmmount = 20;
            contr.pay( paidAmmount);
            }
        catch(ItemRegistryException ItemRegExc){
            handleException("ItemId "+ String.valueOf(searchedItem.getItemID())+ " can not be found in database", ItemRegExc);
        }
        catch(DatabaseFailureException DatabaseExc)
        {
            handleException("Something went wrong in DB", DatabaseExc);
        }
    }
     private void handleException(String uiMsg, Exception exc) {
        errorMsgHandler.showErrorMsg(uiMsg);
        logger.logException(exc);
    }
}
