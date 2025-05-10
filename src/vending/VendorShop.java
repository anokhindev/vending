package vending;

import products.Chocolate;
import products.Product;
import products.Water;

import java.util.ArrayList;
import java.util.*;

public class VendorShop {
    private Map<String, VendingSlot> slots;

    public VendorShop() {
        this.slots = new HashMap<>();
        initialization(); // теперь только ручное заполнение
    }

    public void addSlot(String slotId, Product product, int quantity) {
        var currentSlotId = String.valueOf(slotId);
        this.slots.put(currentSlotId, new VendingSlot(slotId, product, quantity));
    }

    private void initialization() {
        addSlot("01", new Chocolate("Сникерс", 100), 5);
        addSlot("02", new Chocolate("Баунти", 120), 8);
        addSlot("03", new Chocolate("Батончик", 60), 10);
        addSlot("04", new Water("Вода без газа", 80), 6);
        addSlot("05", new Water("Вода с газом", 100), 4);
        addSlot("06", new Water("Кока кола", 120), 7);
    }

    public Collection<VendingSlot> getSlotList() {
        return this.slots.values();
    }

    public VendingSlot getSlot(String slotId) {
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
