/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Class that create and prints info to the log.
 */
public class LogHandler {
    private static final String FILE_NAME = "PoS-log.txt";
    private PrintWriter logFile;
    
    public LogHandler() throws IOException{
        logFile = new PrintWriter(new FileWriter(FILE_NAME), true);
    }
    
    
    public void logException(Exception exception) {
        StringBuilder logMsg = new StringBuilder();
        logMsg.append("Exception was thrown: ");
        logMsg.append(exception.getMessage());
        logFile.println(logMsg);
        exception.printStackTrace(logFile);
    }
}
