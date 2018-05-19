/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.util;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author oscar
 */
public class FileLogger implements Logger {
    private PrintWriter logStream;
   /**
    * Creates a new instance and also creates a new log file.
    **/
    public FileLogger(){
        try{
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe){
            System.out.println("Can not log.");
            ioe.printStackTrace();
        }
    }
    
    /**
     * Specific string gets printed to the log.
     * @param message particualr message to log.
     **/
    @Override
    public void log(String message){
        logStream.println(message);
    }
}
