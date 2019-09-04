import java.util.Scanner;

public class MinAndMaxInputChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int nextNum = 0;

        while (true) {
            System.out.println("Enter number:");
            if (scanner.hasNextInt()) {
                nextNum = scanner.nextInt();

                if (nextNum > max) {
                    max = nextNum;
                    System.out.println("new max is " +max);
                }
                if (nextNum < min) {
                    min = nextNum;
                    System.out.println("new min is " +min);
                }
            }
            else {
                System.out.println("Min: " +min +" Max: " +max);
                break;
            }
            scanner.nextLine(); // handle end of line (enter key)
        }

        scanner.close();
    }
}
