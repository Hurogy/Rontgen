/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Competence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stine
 */
public class CompetenceHandlerTest {

    public CompetenceHandlerTest() {
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
     * Test of getCompetance method, of class CompetenceHandler.
     */
    @Test
    public void testGetCompetance() {
        CompetenceHandler ch = new CompetenceHandler();
        ArrayList<Competence> list = ch.getCompetance();
        int result = list.size();
        DBHandler dbh = DBHandler.getInstance();
        String sql = "Select count(*) From Competence";
        try {
            Statement stmt = dbh.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int expectedResult = rs.getInt(1);
                assertEquals("Antal af elementer på listen passer ikke:", expectedResult, result);       // assertpEquals - sammeligner
            }
        } catch (Exception ex) {
            fail("getCompetence kaster exception: " + ex.getMessage());
        }
    }

}
