import products.Chocolate;
import products.Product;
import products.Water;
import vending.VendingRunner;
import vending.VendorShop;

public class Main {
    public static void main(String[] args) {
        VendorShop shop = new VendorShop();
        VendingRunner runner = new VendingRunner(shop);
        runner.run();
    }
}