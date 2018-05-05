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
        appendLine(builder, "Sale Receipt");
        endSection(builder);
        builder.append("Sold ItemID: ");
        appendLine(builder, StringValueSoldItemID());
        builder.append("Cost: ");
        appendLine(builder, StringValueTotalCost());
        builder.append("Change: ");
        appendLine(builder, StringValueChange());
        endSection(builder);
        
        return builder.toString();
    }
    private String StringValueSoldItemID(){
        return String.valueOf(currentSaleInfo.currentItemDTO().getItemID());
    }
    private String StringValueTotalCost(){
        return String.valueOf(currentSaleInfo.getRunningTotal());
    }
    private String StringValueChange(){
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

