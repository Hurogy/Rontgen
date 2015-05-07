package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Absence;
import model.Staff;

/**
 *
 * @author stine
 */
public class AbsenceHandler {

    private DBHandler dbhandler;
    private ArrayList<Absence> absenceResult;

    public AbsenceHandler() {
        dbhandler = DBHandler.getInstance();
    }

    // Henter alle data fra Absence tabellen, omformer til Absence-obj og returnerer en liste med objekterne
    public ArrayList<Absence> getAbsence() {
        absenceResult = new ArrayList<>();
        try {
            String sql = "Select * From absence";
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String dayStart = rs.getString("dayStart");
                String dayEnd = rs.getString("dayEnd");
                int staffId = rs.getInt("staffId");

                Absence a1 = new Absence(new Staff(staffId), dayStart, dayEnd);

                absenceResult.add(a1);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        return absenceResult;
    }
    
    public ArrayList<Absence> getAbsence(String dayBegyn, String daySlut) {
        absenceResult = new ArrayList<>();
        try {
            String sql = "Select * From absence where dayStart >=" + dayBegyn + " and dayEnd <=" + daySlut;
            Statement stmt = dbhandler.getStmt();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String dayStart = rs.getString("dayStart");
                String dayEnd = rs.getString("dayEnd");
                int staffId = rs.getInt("staffId");

                Absence a1 = new Absence(new Staff(staffId), dayStart, dayEnd);

                absenceResult.add(a1);

            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }

        return absenceResult;
    }

    public void insertAbsence(int id, Staff staff) {
        try {
            String sql = "INSERT INTO Absence VALUES (" + id + ", " + staff.getId() + ");";
            Statement stmt = dbhandler.getStmt();
            stmt.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }

    public void updateAbsence(String newdayStart, String newdayEnd, int newStaffId, int uniqueStaffId) {
        try {
            String sql = " UPDATE absence SET dayStart=" + newdayStart + " dayEnd=" + newdayEnd + " staffId=" + newStaffId + " WHERE staffId =" + uniqueStaffId;
            Statement stmt = dbhandler.getStmt();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }
}
