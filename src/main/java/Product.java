import java.time.LocalDateTime;
import java.util.Date;

public class Product {
    private String type;
    private double price;
    private boolean discount;
    private double discountPercent = 10;
    private LocalDateTime dateAdded;

    public Product(String type, double price, boolean discount, LocalDateTime dateAdded) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.dateAdded = dateAdded;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean getDiscount() {
        return discount;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String toString() {
        return "Product{" +
                "type = '" + type + '\'' +
                ", price = " + price +
                ", discountPercent = " + discountPercent + "% " +
                ", dateAdded = " + dateAdded +
                '}' + "\n";
    }
}
