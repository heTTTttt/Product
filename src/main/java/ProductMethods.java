import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductMethods {
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
    public void discount(List<Product> list) {
        List<Double> discountProduct = list.stream()
                .filter(v -> v.getType().equals("Book"))
                .filter(Product::getDiscount)
                .map(Product::getDiscountPrice)
                .toList();

        discountProduct.forEach(System.out::println);
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
        List<Double> productList = Collections.singletonList(list.stream()
                .filter(v -> v.getType().equals("Book")
                        && v.getDateAdded().equals(dateAdded)
                        && v.getPrice() <= 75)
                .limit(3)
                .mapToDouble(Product::getPrice)
                .sum());

        productList.forEach(System.out::println);
        }

        // Task 6
        public Map groupedTypes(List<Product> list) {

            return list.stream()
                    .collect(Collectors.groupingBy(Product::getType));
            }
        }

