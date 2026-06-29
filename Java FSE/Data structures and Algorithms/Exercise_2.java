import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    // Linear Search
    public static int linearSearch(Product[] products, String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(target))
                return i;
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(Product[] products, String target) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(target);

            if (compare == 0)
                return mid;
            else if (compare < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mouse", "Accessories"),
            new Product(103, "Keyboard", "Accessories"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Tablet", "Electronics")
        };

        // Linear Search
        int linearResult = linearSearch(products, "Phone");
        if (linearResult != -1)
            System.out.println("Linear Search: Product found at index " + linearResult);
        else
            System.out.println("Linear Search: Product not found");

        // Sort for Binary Search
        Arrays.sort(products, (a, b) ->
                a.productName.compareToIgnoreCase(b.productName));

        int binaryResult = binarySearch(products, "Phone");
        if (binaryResult != -1)
            System.out.println("Binary Search: Product found at index " + binaryResult);
        else
            System.out.println("Binary Search: Product not found");
    }
}
}
