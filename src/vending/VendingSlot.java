package vending;

import products.Product;

public class VendingSlot {
    private final Product product;
    private int quantity;
    private final String slotId;

    public VendingSlot(String slotId, Product product, int quantity) {
        this.slotId = slotId;
        this.product = product;
        this.quantity = Math.min(quantity, 10);
    }

    public Product getProduct() { return product; }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public boolean removeProduct() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }

    public String getSlotStatus() {
        return "[" + slotId + "] " + product.getName() + " x" + quantity;
    }
}
