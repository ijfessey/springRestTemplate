import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by ian.fessey on 23/06/2016.
 */
public class ReevooHttpsRequest {


    public static void main(String[] args) throws Exception {


        String username ="NB3g5zWcTmLt1xRIJWgm4A";
        String password ="O-ac25oeKwqTuquo2VL6BTfrxVMT2WQ";

        String userPassword = username+":"+password;

        String httpsURL = "https://api.reevoocloud.com/v4/organisations/LRAU/reviewable?locale=en-AU&sku=ZZZ&format=short";
        URL myurl = new URL(httpsURL);
        HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();

        String basicAuth = "Basic " + new String(new Base64().encode(userPassword.getBytes()));
        con.setRequestProperty("Authorization", basicAuth);

        InputStream ins = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader in = new BufferedReader(isr);

        String inputLine="";
        String jsonString="";

        // only one line
        while ((inputLine = in.readLine()) != null)
        {
            System.out.println(inputLine);
            jsonString = inputLine;
        }
        in.close();

        jsonString = "[" + jsonString + "]";

        JSONArray array = new JSONArray(jsonString);

        // [{"sku":"ZZZ","review_count":2,"average_score":"10.0"}]
        // only onle object returned
        JSONObject jsonObj  = array.getJSONObject(0);
        System.out.println("sku = " + jsonObj.getString("sku"));
        System.out.println("review count = " + jsonObj.getInt("review_count"));
        System.out.println("ave score = " + jsonObj.getDouble("average_score"));


    }
}
