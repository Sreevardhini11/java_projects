
    import java.util.Scanner;

public class currency {

    // Hardcoded exchange rates
    private static final double USD_TO_EUR = 0.91;
    private static final double USD_TO_INR = 82.75;
    private static final double EUR_TO_USD = 1.1;
    private static final double EUR_TO_INR = 90.87;
    private static final double INR_TO_USD = 0.012;
    private static final double INR_TO_EUR = 0.011;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display supported currencies
        System.out.println("Supported Currencies: USD, EUR, INR");

        // Input base currency
        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        // Input target currency
        System.out.print("Enter target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Input amount
        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        // Perform conversion
        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);

        if (convertedAmount != -1) {
            // Display result
            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        } else {
            System.out.println("Invalid currency selection or unsupported conversion.");
        }
    }

    // Method to convert currency
    private static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return amount * USD_TO_EUR;
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("INR")) {
            return amount * USD_TO_INR;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return amount * EUR_TO_USD;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("INR")) {
            return amount * EUR_TO_INR;
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("USD")) {
            return amount * INR_TO_USD;
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("EUR")) {
            return amount * INR_TO_EUR;
        } else {
            return -1; // Unsupported conversion
        }
    }
}

