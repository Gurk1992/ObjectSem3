/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;
import se.kth.iv1350.pos.model.SaleInfo;
/**
 *
 * @author oscar
 */
public class Inventory {
    
    private SaleInfo saleInfo;
            
    public void uppdateInventory(SaleInfo saleInfo){
        this.saleInfo =saleInfo;
    }
}
