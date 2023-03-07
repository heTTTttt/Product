import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductMethods {

    double discount = 10;
    // Task 1
    public void over250(List<Product> list) {
        List<Product> collect = list.stream()
                .filter(v -> v.getType().equals("Book") &&
                        v.getPrice() >= 250)
                .toList();

        System.out.println();
        System.out.println("List after filer: ");
        collect.forEach(System.out::println);
    }

    // Task 2
    public List<Product> discount(List<Product> list) {
        return list.stream()
                .filter(v -> v.getType().equals("Book"))
                .filter(Product::getDiscount)
                .map(v -> new Product(v.getType(), v.getPrice() * (1 - discount / 100),
                     v.getDiscount(), v.getDateAdded()))
                .toList();
    }

    // Task 3
    public Product findCheapestBook(List<Product> productList) throws ProductNotFoundException {
        Optional<Product> cheapestBook = productList.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice));

        if (cheapestBook.isPresent()) {
            return cheapestBook.get();
        } else {
            throw new ProductNotFoundException("Продукт [категорія: Book] не знайдено.");
        }
    }

    // Task 4
    public void lastThreeProducts(List<Product> list) {
        List<Product> latestProducts = list.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();

        latestProducts.forEach(System.out::println);
    }

    // Task 5
    public void generalPriceCountUnder75(List<Product> list, LocalDateTime dateAdded) {
        LocalDate currentDate = LocalDate.now();
        List<Double> productList = Collections.singletonList(list.stream()
                .filter(v -> v.getType().equals("Book"))
                .filter(product -> product.getDateAdded().getYear() == currentDate.getYear()).limit(3)
                .mapToDouble(Product::getPrice)
                .sum());

        productList.forEach(System.out::println);
    }

    // Task 6
    public Map<String, List<Product>> groupedTypes(List<Product> list) {

        return list.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}

