import java.sql.*

public class SQLRequest {
	public static ResultSet request(query) {
        	Connection con = connection();
        	Statement stmt = con.createStatement();
       		ResultSet rs = stmt.executeQuery(query);
        	return rs;
	}
	public static String[][] searchType(String a_type){
		String tab[][]= new String [0][0];
		my_request = "SELECT * FROM objet WHERE type = '" + a_type +"'";
		tab = request(my_request);
		
		return tab;
	}

	public static String[][] searchObjectByDisponibility(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		my_request = "SELECT * FROM objet WHERE disponible = '1'"
		
		
		return tab;
	}
	
	public static String[][] searchObjectByPrice(int x, int y){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] searchObjectByProximity(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] createObject(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] changeObjectDisponibility(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] changeObjectValues(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] changeObjectPrice(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] changeObjectShareTime(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] findObjectBorrowerByDate(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
		
	public static String[][] InterrsestedUsers(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] UsersTypeInterest(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] getUserInfo(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] BeginShare(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}
	
	public static String[][] EndShare(/*TODO*/){
		String tab[][]= new String [0][0];
		//TODO  
		
		
		
		return tab;
	}

}
