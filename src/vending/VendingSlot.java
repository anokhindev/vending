package vending;

import products.Product;

public class VendingSlot {
    private final Product product;
    private int quantity;
    private final int slotId;

    public VendingSlot(int slotId, Product product, int quantity) {
        this.slotId = slotId;
        this.product = product;
        this.quantity = Math.min(quantity, 10);
    }

    public int getSlotId() { return slotId; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public boolean dispense() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }

    public String getSlotStatus() {
        return "[" + slotId + "] " + product + " x" + quantity;
    }
}
