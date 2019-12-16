package testjdbc;


import util.DButil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bmo
 * @date 2019/11/28 19:14
 */
public class TestDBUtil {
    public static void main(String[] args) throws SQLException {
        Connection conn = DButil.getConnection();
        PreparedStatement pstsm = conn.prepareStatement("select * from USERS where age > ?");
        pstsm.setInt(1, 5);
        ResultSet rs = pstsm.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("USERNAME") + "||||" + rs.getString("AGE"));
        }
    }
}
