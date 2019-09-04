package BillsBurgers;

public class DeluxeBurger extends Hamburger {

    private int chips;
    private int chipsPrice = 1;
    private int drink;
    private int drinkPrice = 1;

    public DeluxeBurger(String breadRollType, String meat, int price, String name, int chips, int drink) {
        super(breadRollType, meat, price, name);
        this.drink = drink;
        this.chips = chips;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getChipsPrice() {
        return chipsPrice;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getDrinkPrice () {
        return drinkPrice;
    }

    public int getTotalPrice() {
        return super.getTotalPrice() + (getDrinkPrice() * getDrink()) + (getChipsPrice() * getChips());
    }

    public void printBill() {
        System.out.println("Base Burger Price is " +getPrice());
        System.out.println("Tomato: " +getTomato() + " price: " +(getTomatoPrice() * getTomato()));
        System.out.println("Cheese: " +getCheese()  + " price: " +(getCheesePrice() * getCheese()));
        System.out.println("Carrots: " +getCarrots()  + " price: " +(getCarrotsPrice() * getCarrots()));
        System.out.println("Lettuce: " +getLettuce()  + " price: " +(getLettucePrice() * getLettuce()));
        System.out.println("Chips: " +getChips()  + " price: " +(getChipsPrice() * getChips()));
        System.out.println("Drink: " +getDrink()  + " price: " +(getDrinkPrice() * getDrinkPrice()));
        System.out.println("Grand Total is " +getTotalPrice() +"\n\n");
    }
}
