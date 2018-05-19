/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.startup;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.view.View;
import se.kth.iv1350.pos.integration.Accounting;
import se.kth.iv1350.pos.integration.Inventory;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.util.ConsoleLogger;
import se.kth.iv1350.pos.util.FileLogger;

/**
 *Contains the <code>main</code> method. Preforms all startup
 * of the application.
 * 
 */
public class Main {
    /**
     * Starts the application.
     * @param args Does not take any command line parameters.
     */
    public static void main(String[]args){
 
            Accounting accounting = new Accounting();
            Inventory inventory = new Inventory();
            Printer printer = new Printer();
            Controller contr = new Controller(accounting, inventory, printer);
            View view = new View(contr);
            view.sampleExecution();

    }
    
}
