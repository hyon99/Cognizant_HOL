import java.util.*;
public class Exercise_7
{
    public static Map<Integer, Double> forecastGrowth(double initialAmount, double growthRate, int years) {
        Map<Integer, Double> forecast = new HashMap<>();
        double amount = initialAmount;
        for (int i = 1; i <= years; i++) 
        {
            amount = amount + (amount * growthRate / 100);
            forecast.put(i, amount);
        }
        return forecast;
    }
    public static void main(String[] args) 
  {
        double initialAmount = 10000;
        double growthRate = 8;\
        int years = 5;
        Map<Integer, Double> forecast = forecastGrowth(initialAmount, growthRate, years);
        System.out.println("Financial Forecast:");
        for (Map.Entry<Integer, Double> entry : forecast.entrySet()) 
        {
            System.out.printf("Year %d : %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
