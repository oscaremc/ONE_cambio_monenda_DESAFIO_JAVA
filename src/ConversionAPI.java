import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionAPI {
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
}
