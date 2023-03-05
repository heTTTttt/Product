import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ProductNotFoundException {
        ProductMethods pm = new ProductMethods();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Book", 240, true, LocalDateTime.now().minusHours(1)));
        productList.add(new Product("Book", 2000, true, LocalDateTime.now().minusHours(2)));
        productList.add(new Product("Movie", 260, true, LocalDateTime.now().minusHours(3)));
        productList.add(new Product("Book", 250, false, LocalDateTime.now().minusHours(4)));
        productList.add(new Product("Magazine", 200, false, LocalDateTime.now().minusHours(6)));
        productList.add(new Product("CD-Driver", 250, false, LocalDateTime.now().minusHours(1)));
        productList.add(new Product("Book", 249, true, LocalDateTime.now().minusHours(1)));

        List<Product> productList1 = new ArrayList<>();
        productList1.add(new Product("Picture", 50, false, LocalDateTime.now(). minusYears(1)));
        productList1.add(new Product("Book", 40, true, LocalDateTime.now(). minusYears(0)));
        productList1.add(new Product("Book", 74, true, LocalDateTime.now(). minusYears(0)));
        productList1.add(new Product("Book", 75, true, LocalDateTime.now(). minusYears(0)));
        productList1.add(new Product("Book", 76, true, LocalDateTime.now(). minusYears(0)));
        productList1.add(new Product("Newspaper", 10, false, LocalDateTime.now(). minusYears(1)));

        System.out.println("Task 1:");
        pm.over250(productList);
        System.out.println("======================");
        System.out.println("Task 2:");
        pm.discount(productList);
        System.out.println("======================");
        System.out.println("Task 3:");
        System.out.println(pm.findCheapestBook(productList));
        System.out.println("======================");
        System.out.println("Task 4:");
        pm.lastThreeProducts(productList);
        System.out.println("======================");
        System.out.println("Task 5:");
        pm.generalPriceCountUnder75(productList1, LocalDateTime.now().minusYears(0));
        System.out.println("======================");
        System.out.println("Task 6:");
        Map productMap = pm.groupedTypes(productList1);

        for (Object type : productMap.keySet()) {
            System.out.println(type + ": \n" + productMap.get(type));
        }
    }
}
