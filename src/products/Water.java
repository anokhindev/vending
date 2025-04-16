package products;

import interfaces.IDrinkable;
import interfaces.IEdible;
import interfaces.IRefrigerated;

public class Water extends Product implements IDrinkable, IRefrigerated, IEdible {
    public Water(String name, int price, int number) {
        super(name, price, number);
    }


    @Override
    public void drink() {
        System.out.println("Меня можно пить");
    }

    @Override
    public void eat() {
        System.out.println("Я съедобная");
    }

    @Override
    public boolean requiresRefrigeration() {
        return true;
    }
}
