package Printer;

public class Printer {

    private int tonerLevelPercent;
    private int numPagesPrinted;
    private boolean isDuplex;

    public Printer(int tonerLevelPercent, int numPagesPrinted, boolean isDuplex) {
        this.tonerLevelPercent = tonerLevelPercent;
        this.numPagesPrinted = numPagesPrinted;
        this.isDuplex = isDuplex;
    }

    public void refillToner(int refillPercent) {
        tonerLevelPercent+= refillPercent;

        if (tonerLevelPercent > 100) {
            tonerLevelPercent = 100;
        }
        System.out.println("toner percent is " +tonerLevelPercent);
    }

    public void printPages(int numPages) {
        numPagesPrinted+=numPages;
        System.out.println("printed " +numPagesPrinted +" pages");
    }

}
