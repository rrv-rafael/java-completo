package estaticos.util;

public class CurrencyConverter {
    private static final double IOF = 0.06;

    public static double convertDollarToReal(double priceDollar, double amountDollar) {
        return (priceDollar * amountDollar) + ((priceDollar * amountDollar) * IOF);
    }
}
