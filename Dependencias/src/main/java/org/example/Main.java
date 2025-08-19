package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double[] getCoordinates(String city) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = String.format(
                "https://nominatim.openstreetmap.org/search?format=json&q=%s",
                city.replace(" ", "%20")
        );

        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", "Mozilla/5.0") // Nominatim exige User-Agent
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Erro ao buscar coordenadas");
            }

            String jsonData = response.body().string();
            JSONArray results = new JSONArray(jsonData);

            if (results.length() == 0) {
                throw new RuntimeException("Cidade não encontrada");
            }

            JSONObject location = results.getJSONObject(0);
            double lat = Double.parseDouble(location.getString("lat"));
            double lon = Double.parseDouble(location.getString("lon"));

            return new double[]{lat, lon};
        }
    }

    public static double fetchTemperature(double latitude, double longitude) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = String.format(
                "https://api.open-meteo.com/v1/forecast?latitude=%.4f&longitude=%.4f&current_weather=true&timezone=auto",
                latitude, longitude
        );

        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", "Mozilla/5.0")
                .addHeader("Accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Erro ao buscar temperatura");
            }

            String jsonData = response.body().string();
            JSONObject obj = new JSONObject(jsonData);

            return obj.getJSONObject("current_weather").getDouble("temperature");
        }
    }

    public static void main(String[] args) {
        try {
            String city = "São Paulo";

            double[] coords = getCoordinates(city);
            double tempC = fetchTemperature(coords[0], coords[1]);
            double tempF = celsiusToFahrenheit(tempC);
            System.out.printf("Temperatura atual em %s:%n→ %.1f°C%n→ %.1f°F%n", city, tempC, tempF);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}