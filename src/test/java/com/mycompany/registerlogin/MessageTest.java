
package com.mycompany.registerlogin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        Message instance = null;
        instance.generateMessageID();
        
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.checkRecipientCell();
        assertEquals(expResult, result);
       
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testCheckMessageLength() {
        System.out.println("checkMessageLength");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageLength();
        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = null;
        instance.createMessageHash();
        
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testPrintMessage() {
        System.out.println("printMessage");
        Message instance = null;
        String expResult = "";
        String result = instance.printMessage();
        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }
    
}
