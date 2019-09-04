package BillsBurgers;

public class Hamburger {
    private String breadRollType;
    private String meat;
    private int lettuce;
    private int lettucePrice = 1;
    private int carrots;
    private int carrotsPrice = 1;
    private int tomato;
    private int tomatoPrice = 2;
    private int cheese;
    private int cheesePrice = 2;
    private int price;
    private String name;

    public Hamburger(String breadRollType, String meat, int price, String name) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
        this.name = name;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public int getLettuce() {
        return lettuce;
    }

    public void setLettuce(int lettuce) {
        this.lettuce = lettuce;
    }

    public int getCarrots() {
        return carrots;
    }

    public void setCarrots(int carrots) {
        this.carrots = carrots;
    }

    public int getTomato() {
        return tomato;
    }

    public void setTomato(int tomato) {
        this.tomato = tomato;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public int getCheesePrice() {
        return cheesePrice;
    }

    public int getTomatoPrice() {
        return tomatoPrice;
    }

    public int getCarrotsPrice() {
        return carrotsPrice;
    }

    public int getLettucePrice() {
        return lettucePrice;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPrice() {
        return ( getPrice() + (getLettucePrice() * getLettuce()) + (getCarrotsPrice()
                * getCarrots()) + (getTomatoPrice() * getTomato()) + (getCheesePrice() * getCheese()) );
    }

    public void printBill() {
        System.out.println("Base Burger Price is " +getPrice());
        System.out.println("Tomato: " +getTomato() + " price: " +(getTomatoPrice() * getTomato()));
        System.out.println("Cheese: " +getCheese()  + " price: " +(getCheesePrice() * getCheese()));
        System.out.println("Carrots: " +getCarrots()  + " price: " +(getCarrotsPrice() * getCarrots()));
        System.out.println("Lettuce: " +getLettuce()  + " price: " +(getLettucePrice() * getLettuce()));
        System.out.println("Grand Total is " +getTotalPrice() +"\n\n");
    }
}
