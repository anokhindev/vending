package products;

public abstract class Product {
    protected String name;
    protected int price;
    protected int number;

    public Product(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public void info() {
        System.out.println("Name: " + getName() + ", Price: " + getPrice() + ", Number: " + getNumber());
    }

    public void info(int number) {
        System.out.println("Name: " + getName() + ", Price: " + getPrice() + ", Number: " + getNumber() + ", + перегрузка: " + number);
    }
}
