package estaticos.app;

import estaticos.util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        double priceDollar = scan.nextDouble();

        System.out.print("What is the dollar price? ");
        double amountDollar = scan.nextDouble();

        System.out.printf("Amount to be paid in reais: %.2f%n", CurrencyConverter.convertDollarToReal(priceDollar, amountDollar));
    }
}
