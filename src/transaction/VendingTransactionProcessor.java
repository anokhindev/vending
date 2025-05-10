package transaction;

import person.Person;
import products.Product;
import vending.VendingSlot;
import vending.VendorShop;

public class VendingTransactionProcessor {
    private final VendorShop shop;

    public VendingTransactionProcessor(VendorShop shop) {
        this.shop = shop;
    }

    public Transaction process(Person person, String slotId, double money) {
        VendingSlot slot = shop.getSlot(slotId);
        Product product = slot.getProduct();
        double price = product.getPrice();

        slot.removeProduct(); // удаляем товар
        double change = money - price;

        person.setMoney(person.getBalance() - money + change); //меняем баланс пользователя

        return new Transaction(product, slotId, money, change);
    }
}