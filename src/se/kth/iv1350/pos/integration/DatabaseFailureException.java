/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;

/**
 *
 * If something goes wrong in ItemDatabase exception is trown.
 */
public class DatabaseFailureException extends RuntimeException {
    
    /**
 *Creates a new instance representing the condition described in the specified message.
 * @param msg cointans error message
 */
    public DatabaseFailureException(String msg){
        super();
    }
}