package ishare;

import java.sql.*;
import java.util.*;
import java.net.*;
import org.json.*;

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
            List<Integer> list = new ArrayList<>;
            ResultSet object_result =  request("SELECT objet_id FROM objet ");
            while (result.next()){

                String object_postcode = getObjectLocation(object_result.getInt("objet_id"));

                try {
                    JSONParser parser = new JSONParser();
                    URL myURL =  new URL("http://maps.googleapis.com/maps/api/distancematrix/json?origins="+ user_postcode +",canada&destinations="+ object_postcode +",canada&mode=driving&language=en-EN&sensor=false");
                    URLConnection myURLConnection = myURL.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                    String inputLine = in.readLine());
                    System.out.println(inputLine);
                    Pattern pattern = Pattern.compile("\d*.?\d* km");
                    Matcher matcher = pattern.matcher(inputLine);
                    int distance_trouver;
                    if (matcher.find()){
                        Pattern pattern2 = Pattern.compile("\d*.?\d*");
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
                URLConnection myURLConnection = myURL.openConnection();

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
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO objet (objet_id, type, description, disponible, prix, dureeMax, owner_id) Values ("+
                                                        objet_id+", \'"+
                                                        type+"\', \'"+
                                                        description+"\', "+
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

    public static void createUser(String prenom, String nom, String courriel, int numtel, String code_postal, int numero, String rue, String province, String ville){
        try{
            ResultSet result = request("SELECT COUNT(user_id) AS total FROM ishare_user");
            List<Integer> list = new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("total"));
            }

            int next_id = (int)list.get(0) + 1;
            System.out.println(next_id);
            Connection con = JavaConnect.connection();
            Statement stmt = con.createStatement();

            stmt.executeUpdate("INSERT INTO ishare_user (user_id, prenom, nom, courriel, numtel, code_postal, numero, rue, province, ville) VALUES ("+next_id+ ",\'" +prenom+ "\',\'" +nom+ "\',\'" +courriel+ "\'," + numtel + ",\'" + code_postal +"\',"+numero+",\'"+rue+"\',\'"+province+"\',\'"+ville+"\')");

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
            ResultSet result = request("SELECT disponible FROM objet WHERE objet_id = "+objet_id);
            result.next();
            if (result.getInt("disponible") == 1){
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

    public static List<Integer> InterrsestedUsers(int objet_id){
        try{
            ResultSet result = request("SELECT * FROM interet WHERE objet_id = " + objet_id);
            List<Integer> list= new ArrayList<>();
            while (result.next()){
                list.add(result.getInt("user_id"));
            }
            return list;
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
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

    public static List<String> getObjectInfo(int objet_id){
        try{
            ResultSet result = request("SELECT * FROM objet WHERE objet_id = " + user_id);
            List<String> list= new ArrayList<>();

            result.next()
            list.add(result.getString("type"));
            list.add(result.getString("disponible"));
            list.add(result.getString("prix"));
            list.add(result.getString("dureeMax"));

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
            
            result.next()
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
            Date date = new Date();
            stmt.executeUpdate("INSERT INTO emprunte(user_id, objet_id, duree, date_in, date_out) Values (" + user_id + ", " + object_id + ", " + duree + ", TO_DATE(' "+ date +"', 'DD/MM/YYYY'), NULL); ");
            changeObjectDisponibility(object_id)
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
            Date date = new Date();
            stmt.executeUpdate("UPDATE emprunt SET date_out = TO_DATE(' "+ date +"' WHERE user_id = " + user_id + " AND objet_id = " + object_id);
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
