package transaction;

import person.Person;
import products.Product;

import java.time.LocalDateTime;

public class Transaction {
    private final Product product;
    private final String slotId;
    private final double paidAmount;
    private final double change;
    private final LocalDateTime timestamp;

    public Transaction(Product product, String slotId, double paidAmount, double change) {
        this.product = product;
        this.slotId = slotId;
        this.paidAmount = paidAmount;
        this.change = change;
        this.timestamp = LocalDateTime.now();
    }

    public Product getProduct() {
        return product;
    }

    public double getChange() {
        return change;
    }

    @Override
    public String toString() {
        return String.format("Покупка: %s | Слот: %s | Сумма: %.2f | Сдача: %.2f | Время: %s",
                product.getName(), slotId, paidAmount, change, timestamp.toString());
    }
}