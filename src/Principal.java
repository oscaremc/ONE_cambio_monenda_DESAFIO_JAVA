import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;

public class Principal {
    private static final String API_KEY = "be95dce8ae5eaa40ccfe8bf4";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";
    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + fromCurrency + "/" + toCurrency + "/" + amount)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error al obtener las tasas de cambio");
        }

        Gson gson = new Gson();
        ConversionRates conversionResult = gson.fromJson(response.body(), ConversionRates.class);

        return conversionResult.conversion_result();
    }

    public static void main(String[] args) {
        try {
            String fromCurrency = "USD";
            String toCurrency = "EUR";
            double amount = 100;
            double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
            System.out.println("Cantidad convertida: " + convertedAmount);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}