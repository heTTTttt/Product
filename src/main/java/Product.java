import java.time.LocalDateTime;
import java.util.Date;

public class Product {
    private String type;
    private double price;
    private double discountPercent;
    private LocalDateTime dateAdded;

    public Product(String type, double price, double discountPercent, LocalDateTime dateAdded) {
        this.type = type;
        this.price = price;
        this.discountPercent = discountPercent;
        this.dateAdded = dateAdded;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public double getDiscountPrice() {
        double discountAmount = getPrice() * (getDiscountPercent() / 100);
        return getPrice() - discountAmount;
    }

//    public String toString() {
//        return  "Type: " + getType() + " | " + "Price: " + getPrice();
//    }

    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discountPercent=" + discountPercent +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
