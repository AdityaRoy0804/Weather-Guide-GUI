
import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/weather_app";
    private static final String USER = "root"; // change if needed
    private static final String PASS = "Aditya@2004";     // change if needed

    public static void saveWeather(String city, String temperature, String condition, String humidity) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO weather_history (city, temperature, condition_text, humidity) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, city);
                stmt.setString(2, temperature);
                stmt.setString(3, condition);
                stmt.setString(4, humidity);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getWeatherHistory() {
        StringBuilder history = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM weather_history ORDER BY fetch_time DESC LIMIT 10")) {
            while (rs.next()) {
                history.append("City: ").append(rs.getString("city"))
                        .append(", Temp: ").append(rs.getString("temperature"))
                        .append(", Condition: ").append(rs.getString("condition_text"))
                        .append(", Humidity: ").append(rs.getString("humidity"))
                        .append(", Time: ").append(rs.getTimestamp("fetch_time"))
                        .append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history.toString();
    }
}
