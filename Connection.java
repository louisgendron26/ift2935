import java.sql.*;
import SQLRequest.java
public class JavaConnect {
    public static void main(String[] args) {
        System.out.println("Test");
        x = searchType('velo');
        System.out.println(x);
    }


    public static Connection connection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl",
                    "gendrolo",
                    "olop108G");
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
