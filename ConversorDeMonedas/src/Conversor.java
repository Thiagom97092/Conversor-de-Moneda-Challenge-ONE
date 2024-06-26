import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/79af6a498b2e4bc6cf643c79/latest/";

    public double convertir(String from, String to, double cantidad) {
        URI direccion = URI.create(API_URL + from);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            Double tasa = moneda.conversion_rates.get(to);
            if (tasa != null) {
                return cantidad * tasa;
            } else {
                throw new RuntimeException("No se encontró la tasa de conversión para " + to);
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la tasa de conversión: " + e.getMessage(), e);
        }
    }
}
