/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;


/**
 *
 * 
 */
public class Receipt {
    private SaleInfo currentSaleInfo;
   
    public Receipt (SaleInfo saleInfo){
        this.currentSaleInfo = saleInfo;
    }
    /**
     * Builds a Reciept with SaleInfo.
     * 
     * @return receipt containing SaleInfo as string.
     **/
     public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "Sale");
        endSection(builder);

        builder.append("Sold ItemID: ");
        appendLine(builder, SoldItemID());
        builder.append("Cost: ");
        appendLine(builder, TotalCost());
        builder.append("Change: ");
        appendLine(builder, Change());
        endSection(builder);
        
        return builder.toString();
    }
    private String SoldItemID(){
        return String.valueOf(currentSaleInfo.currentItemDTO().getItemID());
    }
    private String TotalCost(){
        return String.valueOf(currentSaleInfo.getRunningTotal());
    }
    private String Change(){
        return String.valueOf(currentSaleInfo.ammountofChange());
    }
    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}

