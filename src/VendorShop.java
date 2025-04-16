import products.Product;

import java.util.ArrayList;

public class VendorShop {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product prouct) {
        products.remove(prouct);
    }

    public void getProduct(int code, int sum) {
        for (Product product : products) {
            if (product.getNumber() == code) {

                if(sum < product.getPrice()) {
                    System.out.println("не хватает денег");
                    return;
                }
                removeProduct(product);
                System.out.println(product.getName() + " и сдача - " + (sum - product.getPrice()));
                break;
            }
        }
    }


    public void getAllProducts() {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
}
