/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.startup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;


public class MainTest {
    @Test
    public void testMain() {
        PrintStream originalSysOut = null;
        try {
            originalSysOut = System.out;
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            String[] args = null;
            Main.main(args);
            assertTrue("Wrong output when main is executed", outContent.
                       toString().contains("The total price is: "));
        } finally {
            System.setOut(originalSysOut);
        }
    }
}
