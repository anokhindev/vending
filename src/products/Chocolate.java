package products;

import interfaces.IEdible;
import interfaces.IPackaged;

public class Chocolate extends Product implements IPackaged, IEdible {
    public Chocolate(String  name, int price, int number) {
        super(name, price,  number);
    }

    @Override
    public void getPackageType() {
        System.out.println("Этот продукт упакован в бумагу");
    }


    @Override
    public void eat() {
        System.out.println("Этот продукт можно кушать");
    }
}
