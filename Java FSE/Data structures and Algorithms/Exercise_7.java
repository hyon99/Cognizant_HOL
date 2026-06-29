import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double forecast(double amount, double rate, int years) {
        if (years == 0)
            return amount;

        return forecast(amount * (1 + rate / 100), rate, years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Initial Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double futureValue = forecast(amount, rate, years);

        System.out.printf("Future Value after %d years = %.2f\n", years, futureValue);

        sc.close();
    }
}
