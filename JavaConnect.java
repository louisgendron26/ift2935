package ishare;
import java.sql.*;
import java.util.*;

public class JavaConnect {
    public static void main(String[] args) {
        System.out.println("Test");

        //SearchType
        List<Integer> result = new ArrayList<>();
        result = SQLRequest.searchType("velo");
        System.out.println("SearchType : " + result);

        //searchObjectByDisponibility
        List<Integer> result1 = new ArrayList<>();
        result1 = SQLRequest.searchObjectByDisponibility();
        System.out.println("searchObjectByDisponibility : " + result1);

        //searchObjectByPrice
        List<Integer> result2 = new ArrayList<>();
        result2 = SQLRequest.searchObjectByPrice(0, 500);
        System.out.println("searchObjectByPrice : " + result2);
	
	//findObjectBorrowerByDate
	List<Integer> result3 = new ArrayList<>();
	result3 = SQLRequest.findObjectBorrowerByDate(21, "03/04/2017");
	System.out.println("findObjectBorrowerByDate : " + result3);

	//changeObjectPrice
	SQLRequest.changeObjectPrice(60,100);

	//UsersTypeInterested
	SQLRequest.changeObjectDisponibility(1);
	
	//Test pour ajouter un user
	SQLRequest.createUser("Bibi","Cheval", "abc@hotmail.com", 8332611, "J3V2V2", 30, "rue du tisserand", "QC", "Levis");
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
