package ishare;

import java.sql.*;
import java.util.*;

public class SQLRequest {
    public static ResultSet request(String query){
	try{
        	Connection con = JavaConnect.connection();
        	Statement stmt = con.createStatement();
        	ResultSet rs = stmt.executeQuery(query);
		return rs;
	}catch (SQLException se){
		se.printStackTrace();
	}catch (Exception e){
		e.printStackTrace();
	}
	
        return null;
    }

    public static List<Integer> searchType(String type){
        ResultSet result = request("SELECT objet_id FROM objet WHERE type = \'" + type+"\'");
        List<Integer> list= new ArrayList<>();
        try{
		while (result.next()){
            		list.add(result.getInt(1));}
		return list;
	}catch (SQLException se){
		se.printStackTrace();
        }catch (Exception e){
		e.printStackTrace();
	}
        return null;
    }

    public static String[][] searchObjectByDisponibility(){
        String tab[][]= new String [0][0];
        //TODO



        return tab;
    }

    public static String[][] searchObjectByPrice(/*TODO*/){
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
	ResultSet result = request("SELECT objet_id FROM objet WHERE type = \'" + type+"\'");
        List<Integer> list= new ArrayList<>();
        try{
		while (result.next()){
            		list.add(result.getInt(1));}
		return list;
	}catch (SQLException se){
		se.printStackTrace();
        }catch (Exception e){
		e.printStackTrace();
	}
        return null;
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
