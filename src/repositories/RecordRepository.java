package repositories;

import db.interfaces.IDB;
import repositories.interfaces.IRecordRepository;

import java.sql.*;

public class RecordRepository implements IRecordRepository {
    private final IDB db;  // Dependency Injection

    public RecordRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean insert(int point) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO records(score) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, point);

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        }

        return false;
    }
}
