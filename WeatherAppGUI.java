
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherAppGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Weather Guide");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Enter City:");
        label.setBounds(30, 30, 100, 25);
        frame.add(label);

        JTextField cityField = new JTextField();
        cityField.setBounds(130, 30, 200, 25);
        frame.add(cityField);

        JButton fetchButton = new JButton("Fetch Weather");
        fetchButton.setBounds(340, 30, 120, 25);
        frame.add(fetchButton);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(30, 70, 430, 200);
        outputArea.setEditable(false);
        frame.add(outputArea);

        JButton historyButton = new JButton("Show History");
        historyButton.setBounds(180, 280, 130, 25);
        frame.add(historyButton);

        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (city.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a city.");
                    return;
                }

                try {
                    JSONObject data = WeatherFetcher.fetchWeather(city);
                    JSONObject current = data.getJSONObject("current");
                    String temp = current.get("temp_c").toString();
                    String condition = current.getJSONObject("condition").getString("text");
                    String humidity = current.get("humidity").toString();

                    String result = "City: " + city + "\nTemperature: " + temp + " °C\nCondition: " + condition + "\nHumidity: " + humidity + "%";
                    outputArea.setText(result);

                    DatabaseManager.saveWeather(city, temp, condition, humidity);
                } catch (Exception ex) {
                    outputArea.setText("Error fetching weather: " + ex.getMessage());
                }
            }
        });

        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(DatabaseManager.getWeatherHistory());
            }
        });

        frame.setVisible(true);
    }
}
