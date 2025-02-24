import java.util.*;
import java.util.stream.*;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class easy63 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1500),
                new Product("Phone", "Electronics", 800),
                new Product("Table", "Furniture", 200),
                new Product("Shirt", "Clothing", 40),
                new Product("Headphones", "Electronics", 300),
                new Product("Sofa", "Furniture", 1200),
                new Product("Jeans", "Clothing", 60)
        );
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        System.out.println("Grouped by category:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(System.out::println);
        });

        System.out.println("\nMost expensive product in each category:");
        groupedByCategory.forEach((category, productList) -> {
            Product mostExpensive = productList.stream()
                    .max(Comparator.comparingDouble(p -> p.price))
                    .orElse(null);
            System.out.println(category + ": " + mostExpensive);
        });
        double averagePrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
