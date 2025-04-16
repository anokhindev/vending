import products.Chocolate;
import products.Product;
import products.Water;

public class Main {
    public static void main(String[] args) {
        Product snickers = new Chocolate("Snickers", 100, 1);
        Product Bounty = new Chocolate("Bounty", 120, 2);
        Product water = new Water("Water", 90, 3);
        Product water2 = new Water("Water2", 90, 4);
        Product water3 = new Water("Water3", 90, 5);
        Product water4 = new Water("Water4", 90, 6);

        VendorShop vendorShop = new VendorShop();

        vendorShop.addProduct(snickers);
        vendorShop.addProduct(Bounty);
        vendorShop.addProduct(water);
        vendorShop.addProduct(water2);
        vendorShop.addProduct(water3);
        vendorShop.addProduct(water4);

        vendorShop.getAllProducts(); //получаем весь список
        vendorShop.getProduct(1, 20); //не хватает денег
        vendorShop.getProduct(1, 200); //получаем сникерс и сдача 100
        vendorShop.getAllProducts(); //получаем весь список
    }
}