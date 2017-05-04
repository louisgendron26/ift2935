package ishare;

import java.sql.*;
import java.util.*;

public class SQLRequest {

    public static ResultSet request(String query) {
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

        try{
            ResultSet result = request("SELECT objet_id FROM objet WHERE type = \'" + type+"\'");
            List<Integer> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("objet_id"))
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;


    }

    public static List<Integer> searchObjectByDisponibility(){
        try{
            result = request("SELECT objet_id FROM objet WHERE disponible = \'1\'" );
            List<String> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("objet_id"))
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Integer> searchObjectByPrice(int lower_price, int higer_price){
        try{
            result = request("SELECT objet_id FROM objet WHERE (prix BETWEEN "+lower_price+" AND "+higer_price+")");
            List<String> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("objet_id"))
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String[][] searchObjectByProximity(){
        String tab[][]= new String [0][0];
        //TODO



        return tab;
    }

    public static void createObject(int objet_id, String type, String description, boolean disponible, int prix, int duree_partage, int owner_id){
        try{
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values ("+
                                                        objet_id+", "+
                                                        type+", "+
                                                        description+", "+
                                                        disponible+", "+
                                                        prix+", "+
                                                        duree_partage+", "+
                                                        owner_id");");
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void changeObjectDisponibility(int objet_id){
        try{
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            result = request("SELECT disponible FROM object WHERE object_id = \'"+objet_id+"\'");
            if result.getInt(1){
                stmt.executeUpdate("UPDATE objet SET disponible = 0");
            }else{
                stmt.executeUpdate("UPDATE objet SET disponible = 1");
            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changeObjectPrice(int object_id,int price){
        try{
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE objet SET price = \'"+ price +"\' WHERE object_id = \'"+object_id+"\'");
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void changeObjectShareTime(int share_time){
        try{
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE objet SET dureeMax = \'"+share_time+"\'");
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String[][] findObjectBorrowerByDate(Date date){
        String tab[][]= new String [0][0];
        //TODO



        return tab;
    }

    public static List<Integer> InterrsestedUsers(int objet_id){
        try{
            result = request("SELECT * FROM interet WHERE objet_id = \'" + objet_id+"\'");
            List<String> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("user_id"))
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> UsersTypeInterest(int user_id){
        try{
            result = request("SELECT type FROM objet WHERE objet_id = \'(SELECT objet_id FROM interet WHERE = \'" + user_id +"\')\'");
            List<String> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getString("type"))
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getUserInfo(int user_id){
        Courriel;
        Nom;
        Prenom;


        String tab[][]= new String [0][0];
        //TODO



        return tab;
    }

    public static Map<String, String> getObject(int object_id){
        try{
            result = request("SELECT * FROM objet WHERE objet_id = \'" + object_id +"\')\'");


        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;




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
