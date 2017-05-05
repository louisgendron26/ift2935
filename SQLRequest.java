package ishare;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.net.*;
import java.io.*;

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
                list.add(result.getInt("objet_id"));
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
            ResultSet result = request("SELECT objet_id FROM objet WHERE disponible = \'1\'" );
            List<Integer> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("objet_id"));
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
            ResultSet result = request("SELECT objet_id FROM objet WHERE (prix BETWEEN "+lower_price+" AND "+higer_price+")");
            List<Integer> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("objet_id"));
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void addTypeInfo(int objet_id, String type, List<String> type_info){
        try{
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            if (type.equals("maison")){
                stmt.executeUpdate("INSERT INTO maison (objet_id, annee, superficie, etage, chambre, meuble, stationnement, salle_bain) VALUES ("+objet_id+ "," +type_info.get(0)+ "," +type_info.get(1)+ ","+type_info.get(2)+ "," +type_info.get(3)+ "," +type_info.get(4)+","+type_info.get(5)+","+type_info.get(6)+","+type_info.get(7)+","+type_info.get(8)+")");
            } else if (type.equals("auto")) {
                stmt.executeUpdate("INSERT INTO auto (objet_id, marque, modele, couleur, annee, transmission_manuel, nbPortes, consommation) VALUES ("+objet_id+ ",\'" +type_info.get(0)+ "\',\'" +type_info.get(1)+ "\',\'"+type_info.get(2)+ "\'," +type_info.get(3)+ "," +type_info.get(4)+","+type_info.get(5)+","+type_info.get(6)+")");
            } else if (type.equals("velo")) {
                stmt.executeUpdate("INSERT INTO velo (objet_id, type_velo, marque, modele, cadre, freins, taille_pneus, annee, sexe) VALUES ("+objet_id+ ",\'" +type_info.get(0)+ "\',\'" +type_info.get(1)+ "\',\'"+type_info.get(2)+ "\',\'" +type_info.get(3)+ "\',\'" +type_info.get(4)+"\',\'"+type_info.get(5)+"\',"+type_info.get(6)+","+type_info.get(7)+")");
            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }

    public static String getObjectLocation(int objet_id){
        try{
            ResultSet result = request("SELECT b.code_postal FROM objet a ishare_user b WHERE (a.owner_id = b.user_id) AND a.objet_id = " + objet_id );
            result.next();
            String code_postal = result.getString("code_postal");
            return code_postal;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;



    }

    public static List<Integer> searchObjectByProximity(int distance, int user_id){
        try{
            ResultSet result = request("SELECT b.code_postal FROM ishare_user user_id = " + user_id );
            result.next();
            String user_postcode = result.getString("code_postal");
            List<Integer> list = new ArrayList<>();
            ResultSet object_result =  request("SELECT objet_id FROM objet ");
            while (result.next()){

                String object_postcode = getObjectLocation(object_result.getInt("objet_id"));

                try {
                    URL myURL =  new URL("http://maps.googleapis.com/maps/api/distancematrix/json?origins="+ user_postcode +",canada&destinations="+ object_postcode +",canada&mode=driving&language=en-EN&sensor=false");
                    URLConnection myURLConnection = myURL.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                    String inputLine = in.readLine();
                    System.out.println(inputLine);
                    Pattern pattern = Pattern.compile("\\d*.?\\d* km");
                    Matcher matcher = pattern.matcher(inputLine);
                    String distance_trouver = null;
                    if (matcher.find()){
                        Pattern pattern2 = Pattern.compile("\\d*.?\\d*");
                        Matcher matcher2 = pattern2.matcher(matcher.group(1));
                        if (matcher2.find()){
                            distance_trouver = matcher2.group(1);
                        }
                    }

                    if (Integer.parseInt(distance_trouver) < distance){
                        list.add(object_result.getInt("objet_id"));
                    }
                    in.close();
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;


    }

    public static void createObject(String type, String description, boolean disponible, int prix, int duree_partage, int owner_id){
        try{

            ResultSet result = request("SELECT COUNT(object_id) AS total FROM objet");
            int current_id = list.add(result.getInt("total"));
            int next_id = current_id + 1;

            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values ("+
                    next_id+", \'"+
                    type+"\', \'"+
                    description+"\', "+
                    disponible+", "+
                    prix+", "+
                    duree_partage+", "+
                    owner_id + ")");
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void createUser(String prenom, String nom, String courriel, int numtel, String code_postal, int numero, String rue, String province, String ville){
        try{
            ResultSet result = request("SELECT COUNT(object_id) AS total FROM objet");
            int current_id = list.add(result.getInt("total"));
            int next_id = current_id + 1;

            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();

            stmt.executeUpdate("INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) VALUES ("+next_id+ ",\'" +prenom+ "\',\'" +nom+ "\',\'" +courriel+ "\'," + numtel + ",\'" + code_postal +"\',"+numero+",\'"+rue+"\',\'"+province+"\',\'"+ville+"\')");

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
            stmt.executeUpdate("UPDATE objet SET prix = \'"+ price +"\' WHERE objet_id = \'"+object_id+"\'");
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

    public static List<Integer> findObjectBorrowerByDate(int obj_id, String date){
        try{
            ResultSet result = request("SELECT user_id FROM emprunte WHERE objet_id = "+ obj_id + " AND date_in <= TO_DATE(\'"+ date + "\', \'DD/MM/YYYY\') AND date_out >= TO_DATE(\'"+ date + "\', \'DD/MM/YYYY\')");
            List<Integer> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("user_id"));
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    

    public static List<Integer> interrsestedUsers(int objet_id){
        try{
            ResultSet result = request("SELECT * FROM interet WHERE objet_id = " + objet_id);
            List<Integer> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("user_id"));
            }
            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getObjetInfo(int objet_id){

        try{
            ResultSet result = request("SELECT type FROM (SELECT * FROM objet WHERE objet_id ="+objet_id+")");
            String my_type= "";
            result.next();
            my_type = my_type + (result.getString("type"));
            ResultSet result_end = request("SELECT * FROM objet NATURAL JOIN "+ my_type + " WHERE objet_id ="+objet_id);
            List<String> list = new ArrayList<>();
            result_end.next();
            list.add(""+result_end.getInt("objet_id"));
            list.add(result_end.getString("type"));
            list.add(result_end.getString("description"));
            list.add(""+result_end.getInt("disponible"));
            list.add(""+result_end.getInt("prix"));
            list.add(""+result_end.getInt("dureemax"));
            list.add(""+result_end.getInt("owner_id"));

            if(my_type.equals("auto")){
                list.add(result_end.getString("marque"));
                list.add(result_end.getString("modele"));
                list.add(result_end.getString("couleur"));
                list.add(""+result_end.getInt("annee"));
                list.add(""+result_end.getInt("transmission_manuel"));
                list.add(""+result_end.getInt("nbPortes"));
                list.add(""+result_end.getInt("consommation"));
            }else if (my_type.equals("maison")){
                list.add(""+result_end.getInt("annee"));
                list.add(""+result_end.getInt("superficie"));
                list.add(""+result_end.getInt("etage"));
                list.add(""+result_end.getInt("chambre"));
                list.add(""+result_end.getInt("meuble"));
                list.add(""+result_end.getInt("stationnement"));
                list.add(""+result_end.getInt("salle_bain"));
            }else{
                list.add(result_end.getString("type_velo"));
                list.add(result_end.getString("marque"));
                list.add(result_end.getString("modele"));
                list.add(result_end.getString("cadre"));
                list.add(result_end.getString("freins"));
                list.add(result_end.getString("taille_pneus"));
                list.add(""+result_end.getInt("annee"));
                list.add(result_end.getString("sexe"));
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
        try{
            ResultSet result = request("SELECT * FROM ishare_user WHERE user_id = " + user_id);
            List<String> list= new ArrayList<>();

            result.next();
            list.add(result.getString("prenom"));
            list.add(result.getString("nom"));
            list.add(result.getString("courriel"));
            list.add(result.getString("numtel"));
            list.add(result.getString("code_postal"));
            list.add(result.getString("numero"));
            list.add(result.getString("rue"));
            list.add(result.getString("province"));
            list.add(result.getString("ville"));

            return list;
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void BeginShare(int user_id, int object_id, int duree){
        try{
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
            Calendar cal = Calendar.getInstance();
            stmt.executeUpdate("INSERT INTO emprunte(user_id, objet_id, duree, date_in, date_out) Values (" + user_id + ", " + object_id + ", " + duree + ", TO_DATE(' "+ cal +"', 'DD/MM/YYYY'), NULL); ");
            changeObjectDisponibility(object_id);
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void EndShare(int user_id, int object_id){
        try{
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
            Calendar cal = Calendar.getInstance();

            stmt.executeUpdate("UPDATE emprunt SET date_out = TO_DATE(' "+ cal +"' WHERE user_id = " + user_id + " AND objet_id = " + object_id);
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
