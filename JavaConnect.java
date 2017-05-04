package ishare;
import java.sql.*;
import java.util.*;

public class JavaConnect {
    public static void main(String[] args) {
        System.out.println("Test");

        //SearchType
        List<Integer> result = new ArrayList<>();
        res = SQLRequest.searchType("velo");
        System.out.println("SearchType : " + result);

        //searchObjectByDisponibility
        List<Integer> result = new ArrayList<>();
        res = SQLRequest.searchObjectByDisponibility();
        System.out.println("searchObjectByDisponibility : " + result);

        //searchObjectByPrice
        List<Integer> result = new ArrayList<>();
        res = SQLRequest.searchObjectByPrice(0, 500);
        System.out.println("searchObjectByPrice : " + result);

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
