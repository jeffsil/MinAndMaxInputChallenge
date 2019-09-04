package BillsBurgers;

public class HealthyBurger extends Hamburger{

    private int pickle;
    private int picklePrice = 1;
    private int cucumber;
    private int cucumberPrice = 1;

    public HealthyBurger(String meat, int price, String name) {
        super("brownRye", meat, price, name);
    }

    public int getPickle() {
        return pickle;
    }

    public void setPickle(int pickle) {
        this.pickle = pickle;
    }

    public int getPicklePrice() {
        return picklePrice;
    }

    public int getCucumber() {
        return cucumber;
    }

    public void setCucumber(int cucumber) {
        this.cucumber = cucumber;
    }

    public int getCucumberPrice() {
        return cucumberPrice;
    }

    public int getTotalPrice() {
        return super.getTotalPrice() + (getPicklePrice() * getPickle()) + (getCucumberPrice() * getCucumber());
    }

    public void printBill() {
        System.out.println("Base Burger Price is " +getPrice());
        System.out.println("Tomato: " +getTomato() + " price: " +(getTomatoPrice() * getTomato()));
        System.out.println("Cheese: " +getCheese()  + " price: " +(getCheesePrice() * getCheese()));
        System.out.println("Carrots: " +getCarrots()  + " price: " +(getCarrotsPrice() * getCarrots()));
        System.out.println("Lettuce: " +getLettuce()  + " price: " +(getLettucePrice() * getLettuce()));
        System.out.println("Cucumber: " +getCucumber()  + " price: " +(getCucumberPrice() * getCucumber()));
        System.out.println("Pickle: " +getPickle()  + " price: " +(getPicklePrice() * getPickle()));
        System.out.println("Grand Total is " +getTotalPrice() +"\n\n");
    }
}
