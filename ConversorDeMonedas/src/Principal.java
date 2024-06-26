import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        while (true) {
            System.out.println("Por favor seleccione la opción que desea convertir o escriba '0' para finalizar la aplicación.");
            System.out.println("""
                    1. Dólar a Euro.
                    2. Euro a Dólar.
                    3. Dólar a Peso Argentino.
                    4. Peso Argentino a Dólar.
                    5. Dólar a Peso Colombiano.
                    6. Peso Colombiano a Dólar.
                    7. Dólar a Peso Cubano.
                    8. Peso Cubano a Dólar.
                    0. Salir""");
            var opcion = Integer.parseInt(lectura.nextLine());
            if (opcion == 0) {
                System.out.println("Aplicación finalizada.");
                break;
            }
            Conversor conversor = new Conversor();
            double cantidad = 1;  // Supongamos que queremos convertir 1 unidad
            switch (opcion) {
                case 1 -> System.out.println(conversor.convertir("USD", "EUR", cantidad));
                case 2 -> System.out.println(conversor.convertir("EUR", "USD", cantidad));
                case 3 -> System.out.println(conversor.convertir("USD", "ARS", cantidad));
                case 4 -> System.out.println(conversor.convertir("ARS", "USD", cantidad));
                case 5 -> System.out.println(conversor.convertir("USD", "COP", cantidad));
                case 6 -> System.out.println(conversor.convertir("COP", "USD", cantidad));
                case 7 -> System.out.println(conversor.convertir("USD", "CUP", cantidad));
                case 8 -> System.out.println(conversor.convertir("CUP", "USD", cantidad));
                default -> System.out.println("Opción no válida. Por favor intente nuevamente.");
            }
        }
    }
}
