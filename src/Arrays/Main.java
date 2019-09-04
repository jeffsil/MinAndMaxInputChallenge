package Arrays;

import java.util.Scanner;

class IntegerArray {
    private boolean isActive;
    private int value;

    public IntegerArray(int value) {
        this.isActive = true;
        this.value = value;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IntegerArray[] myIntegers = getIntegers(5);

        printArray(myIntegers);
        printArray(sortIntegers(myIntegers));


    }

    public static IntegerArray[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        IntegerArray[] values = new IntegerArray[number];

        for(int i=0; i<values.length; i++) {
            values[i] = new IntegerArray(scanner.nextInt());
        }

        return values;
    }

    public static void printArray(int[] array) {
        System.out.println("\nSORTED");
        for(int i=0; i<array.length; i++) {
            System.out.println("Element " + i +", typed value was " + array[i]);
        }
    }

    public static void printArray(IntegerArray[] array) {
        System.out.println("\nUNSORTED");
        for(int i=0; i<array.length; i++) {
            System.out.println("Element " + i +", typed value was " + array[i].getValue());
        }
    }

    public static int[] sortIntegers(IntegerArray[] array) {
        int[] sortedArray = new int[array.length];

        // find max from array
        for (int j=0; j < sortedArray.length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (j != 0) {
                    if (!array[i].isActive()) {
                        continue;
                    }
                }
                if (max <= array[i].getValue()) {
                    sortedArray[j] = array[i].getValue();
                    max = sortedArray[j];
                }
            }
            // mark value from array as inactive
            for (int i=0; i < array.length; i++) {
                if ( array[i].isActive() && (sortedArray[j] == array[i].getValue())) {
                    array[i].setActive(false);
                    break;
                }
            }
        }
        return sortedArray;
    }
}
