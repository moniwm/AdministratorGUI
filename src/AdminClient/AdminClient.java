package AdminClient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AdminClient {

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        return result.toString();
    }

    public static void main(String[] args) throws Exception
    {

        ArrayList<Users> users = new ArrayList<Users>();
        String name;
        String email;
        String password;
        boolean chef;
        boolean admin;

        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(getHTML("http://localhost:8080/CookTime.BackEnd/api/users"));


        for (int i = 0; i < json.size(); i++){

            JSONObject item = (JSONObject) parser.parse(json.get(i).toString());

            name = item.get("name").toString();
            email = item.get("email").toString();
            password = item.get("password").toString();
            chef = Boolean.parseBoolean(item.get("chef").toString());
            admin = Boolean.parseBoolean(item.get("admin").toString());

            Users user = new Users(name, email, password, chef, admin);
            users.add(user);
        }

        System.out.println(users.toString());


    }
}