package BillsBurgers;

public class Main {

    public static void main(String[] args) {
        // Create a class and demonstate proper encapsulation techniques
        // the class will be called Printer
        // It will simulate a real Computer Printer
        // It should have fields for the toner Level, number of pages printed, and
        // also whether its a duplex printer (capable of printing on both sides of the paper).
        // Add methods to fill up the toner (up to a maximum of 100%), another method to
        // simulate printing a page (which should increase the number of pages printed).
        // Decide on the scope, whether to use constructors, and anything else you think is needed.
        Hamburger hamburger = new Hamburger("white", "beef", 2, "custom");
        hamburger.setCheese(2);
        hamburger.printBill();


        HealthyBurger healthyBurger = new HealthyBurger("beef", 2, "healthy");
        healthyBurger.setCucumber(2);
        healthyBurger.setCarrots(1);
        healthyBurger.printBill();


        DeluxeBurger deluxeBurger = new DeluxeBurger("white", "beef", 2, "deluxe", 1,1);
        deluxeBurger.printBill();


    }
}
