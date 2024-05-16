import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //UI Menu
        Menu.head();
        // Solicitar y validar fromCurrency
        System.out.print("Ingrese la moneda de origen: ");
        String fromCurrency = scanner.nextLine().trim().toUpperCase();
        while (fromCurrency.isEmpty()) {
            System.out.print("Moneda de origen no puede estar vacía. Ingrese nuevamente: ");
            fromCurrency = scanner.nextLine().trim().toUpperCase();
        }

        // Solicitar y validar toCurrency
        System.out.print("Ingrese la moneda de destino: ");
        String toCurrency = scanner.nextLine().trim().toUpperCase();
        while (toCurrency.isEmpty()) {
            System.out.print("Moneda de destino no puede estar vacía. Ingrese nuevamente: ");
            toCurrency = scanner.nextLine().trim().toUpperCase();
        }

        // Solicitar y validar amount
        double amount = 0;
        boolean validAmount = false;
        while (!validAmount) {
            System.out.print("Ingrese el monto a convertir: ");
            String amountStr = scanner.nextLine().trim();
            try {
                amount = Double.parseDouble(amountStr);
                if (amount <= 0) {
                    System.out.println("El monto debe ser un número positivo. Intente nuevamente.");
                } else {
                    validAmount = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número válido.");
            }
        }

        // Continuar con el flujo
        try {
            double convertedAmount = ConversionAPI.convertCurrency(fromCurrency, toCurrency, amount);
            System.out.println("Cantidad convertida: " + convertedAmount);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}