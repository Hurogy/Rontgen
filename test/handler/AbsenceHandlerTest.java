/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Absence;
import model.Staff;
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
public class AbsenceHandlerTest {

    public AbsenceHandlerTest() {
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
     * Test of getAbsence method, of class AbsenceHandler.
     */
    @Test
    public void testGetAbsence() {
        System.out.println("Test for getAbsence");
        AbsenceHandler ah = new AbsenceHandler();
        ArrayList<Absence> list = ah.getAbsence();
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From absence";    //Tæller elementer i absence i DB, skriver samlede antal elementer ud
        try {
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int expectedResult = rs.getInt(1);
                assertEquals("Antal af elementer på listen passer ikke:", expectedResult, result);       // assertpEquals - sammeligner
            }

        } catch (Exception ex) {
            fail("getAbsence kaster exception: " + ex.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.

    }

}
