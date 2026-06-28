import java.util.Arrays;
import java.util.Scanner;
public class Exercise_2
{
    public static int binarySearch(String[] products, String target) 
    {
        int low = 0, high = products.length - 1;
        while (low <= high) 
            {
            int mid = (low + high) / 2;
            int compare = products[mid].compareToIgnoreCase(target);
            if (compare == 0)
                return mid;
            else if (compare < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        String[] products = {
            "Laptop",
            "Mouse",
            "Keyboard",
            "Smartphone",
            "Tablet"
        };
        Arrays.sort(products);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product to search: ");
        String target = sc.nextLine();
        int result = binarySearch(products, target);
        if (result != -1)
            System.out.println(target + " found at position " + (result + 1));
        else
            System.out.println(target + " not found.");
        sc.close();
    }
}