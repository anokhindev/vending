import vending.VendingRunner;
import vending.VendingShop;

public class Main {
    public static void main(String[] args) {
        VendingShop shop = new VendingShop();
        VendingRunner runner = new VendingRunner(shop);
        runner.run();
    }
}