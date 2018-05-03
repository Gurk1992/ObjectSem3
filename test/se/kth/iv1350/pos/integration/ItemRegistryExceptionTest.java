/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oscar
 */
public class ItemRegistryExceptionTest {
   
    
    @Test(expected = ItemRegistryException.class)
    public void testSomeMethod() {
        throw new ItemRegistryException("´1234 sda");
        
    }
    
}
