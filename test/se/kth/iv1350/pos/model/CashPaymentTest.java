/* ---- DONT THINK I NEED TO DO THIS TEST-----
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;

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
public class CashPaymentTest {
    
    public CashPaymentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalPrice method, of class CashPayment.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        SaleInfo paidSaleInfo = null;
        CashPayment instance = null;
        instance.getTotalPrice(paidSaleInfo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalCost method, of class CashPayment.
     */
    @Test
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        CashPayment instance = null;
        int expResult = 0;
        int result = instance.getTotalCost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaidAmmount method, of class CashPayment.
     */
    @Test
    public void testGetPaidAmmount() {
        System.out.println("getPaidAmmount");
        CashPayment instance = null;
        int expResult = 0;
        int result = instance.getPaidAmmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
