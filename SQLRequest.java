import Connection;
import java.sql.*;
import java.util.*;

public class SQLRequest {

    public static ResultSet request(query) {
        Connection con = connection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public static String[] searchType(String type){
        result = request("SELECT * FROM objet WHERE type == " + type);
        List<String> list= new ArrayList<>();
        while (result.next()){
            list.add(result.getInt("objet_id "))
        }
        return list;
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
