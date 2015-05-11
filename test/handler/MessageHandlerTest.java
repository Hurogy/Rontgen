/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Message;
import model.Staff;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Birgit Schæffer
 */
public class MessageHandlerTest {
    
    public MessageHandlerTest() {
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
     * Test of getMessage method, of class MessageHandler.
     */
    @Test
    public void testGetMessage() {
        MessageHandler ah = new MessageHandler();
        ArrayList<Message> list = ah.getMessage();
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From message";
        try{
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            int expectedResult = rs.getInt(1);
        assertEquals("Antal af elementer på listen passer ikke:",expectedResult, result);
        } catch (Exception ex){
            fail("getMessage kaster exception: "+ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of insertMesssage method, of class MessageHandler.
     */
    @Test
    public void testInsertMesssage() {
        System.out.println("insertMesssage");
        String description = "";
        Staff staff = null;
        MessageHandler instance = new MessageHandler();
        instance.insertMesssage(description, staff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMessage method, of class MessageHandler.
     */
    @Test
    public void testUpdateMessage() {
        System.out.println("updateMessage");
        String newdescription = "";
        int newstaffId = 0;
        String uniquestaffId = "";
        MessageHandler instance = new MessageHandler();
        instance.updateMessage(newdescription, newstaffId, uniquestaffId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
