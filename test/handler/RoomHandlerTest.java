/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Room;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas
 */
public class RoomHandlerTest {

    public RoomHandlerTest() {
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
     * Test of getRoom method, of class RoomHandler.
     */
    @Test
    public void testGetRoom() {
        System.out.println("Test for getRoom");
        RoomHandler rh = new RoomHandler();
        ArrayList<Room> list = rh.getRoom();
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) from room";
        try {
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            int expectedResult = rs.getInt(1);
            assertEquals("Antal af elementer i listen passer ikke: ", expectedResult, result);
        } catch (Exception ex) {
            fail("getRoom kaster exception: " + ex.getMessage());
        }
    }

    /**
     * Test of insertRoom method, of class RoomHandler.
     */
//    @Test
//    public void testInsertRoom() {
//        System.out.println("insertRoom");
//        int id = 0;
//        String type = "";
//        String status = "";
//        int minStaffAmount = 0;
//        int maxStaffAmount = 0;
//        String validFrom = "";
//        RoomHandler instance = new RoomHandler();
//        instance.insertRoom(id, type, status, minStaffAmount, maxStaffAmount, validFrom);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateRoom method, of class RoomHandler.
//     */
//    @Test
//    public void testUpdateRoom() {
//        System.out.println("updateRoom");
//        int newRoomId = 0;
//        String newTyp = "";
//        String newState = "";
//        int newMinStaffAmount = 0;
//        int newMaxStaffAmount = 0;
//        String newValidFrom = "";
//        int uniqueId = 0;
//        RoomHandler instance = new RoomHandler();
//        instance.updateRoom(newRoomId, newTyp, newState, newMinStaffAmount, newMaxStaffAmount, newValidFrom, uniqueId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
