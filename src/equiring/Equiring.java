package equiring;

import vending.VendingSlot;
import vending.VendingShop;
import person.Person;

public class Equiring {
    private final VendingShop shop;

    public Equiring(VendingShop shop) {
        this.shop = shop;
    }

    public boolean isSlotValid(String slotId) {
        return shop.getSlot(slotId) != null;
    }

    public boolean isProductAvailable(String slotId) {
        VendingSlot slot = shop.getSlot(slotId);
        return slot != null && slot.isAvailable();
    }

    public boolean hasEnoughMoney(String slotId, double money) {
        VendingSlot slot = shop.getSlot(slotId);
        return slot != null && money >= slot.getProduct().getPrice();
    }

    public double getPrice(String slotId) {
        return shop.getSlot(slotId).getProduct().getPrice();
    }

    public boolean personCanProvide(Person person, double amount) {
        return person.getBalance() >= amount;
    }

    public double getRequiredAmount(String slotId) {
        return shop.getSlot(slotId).getProduct().getPrice();
    }


}