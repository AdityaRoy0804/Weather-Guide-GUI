
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherFetcher {
    private static final String API_KEY = "3cf4b430cb7149aa81f102452251905";

    public static JSONObject fetchWeather(String city) throws Exception {
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + city;
        HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder jsonSB = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonSB.append(line);
        }

        return new JSONObject(jsonSB.toString());
    }
}
