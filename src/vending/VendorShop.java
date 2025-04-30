package vending;

import products.Chocolate;
import products.Product;
import products.Water;

import java.util.ArrayList;
import java.util.*;

public class VendorShop {
//    private ArrayList<Product> products = new ArrayList<>();
//
//    public void addProduct(Product product) {
//        products.add(product);
//    }
//
//    public void removeProduct(Product prouct) {
//        products.remove(prouct);
//    }
//
//    public void getAndRemoveProduct(int code, int sum) {
//        for (Product product : products) {
//            if (product.getNumber() == code) {
//
//                if(sum < product.getPrice()) {
//                    System.out.println("не хватает денег");
//                    return;
//                }
//                removeProduct(product);
//                System.out.println(product.getName() + " и сдача - " + (sum - product.getPrice()));
//                break;
//            }
//        }
//    }
//
//    public Product getProduct(int code) {
//        return products.stream().filter(product -> product.getNumber() == code).findFirst().orElse(null);
//    }
//
//
//    public ArrayList<Product> getAllProducts() {
//        for (Product product : products) {
//            System.out.println(product.getName());
//        }
//
//        return products;
//    }


    private Map<String, VendingSlot> slots;

    public VendorShop() {
        this.slots = new HashMap<>();
        initialization(); // теперь только ручное заполнение
    }

    public void addSlot(int slotId, Product product, int quantity) {
        var currentSlotId = String.valueOf(slotId);
        this.slots.put(currentSlotId, new VendingSlot(slotId, product, quantity));
    }

    private void initialization() {
        addSlot(1, new Chocolate("Сникерс", 100), 5);
        addSlot(2, new Chocolate("Баунти", 120), 8);
        addSlot(3, new Chocolate("Батончик", 60), 10);
        addSlot(4, new Water("Вода без газа", 80), 6);
        addSlot(5, new Water("Вода с газом", 100), 4);
        addSlot(6, new Water("Кока кола", 120), 7);
    }

    public Collection<VendingSlot> getSlotList() {
        return this.slots.values();
    }

    public VendingSlot getSlot(int slotId) {
        return this.slots.get(slotId);
    }

    public ArrayList<Product> getRangeOfProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        for (VendingSlot slot : slots.values()) {
            productList.add(slot.getProduct());
        }
        return productList;
    }

}
