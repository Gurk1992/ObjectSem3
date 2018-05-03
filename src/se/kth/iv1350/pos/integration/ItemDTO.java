/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;

/**
 *Creates a new instance representing a particualr item
 *
 */
public final class ItemDTO {
    private final int itemId;
    private final int quantity;
    private final int price;
    
  /**
 *Creates a new instance representing a particualr car
 * @param itemId     The itemId of the item.
 * @param quantity   The quantity of the specific item.
 * @param price      The price of current item input from view = 0.
 */
    public ItemDTO (int itemId, int quantity, int price){
        this.itemId = itemId;
        this.quantity = quantity;
        this.price =  price;
    }
    
    public int getItemID()
    {
        return this.itemId;
    }
    public int getQuantity()
    {
        return this.quantity;
    }   
    public int getPrice(){
        return this.price;
    }   
    
}
