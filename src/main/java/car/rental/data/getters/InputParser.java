package car.rental.data.getters;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputParser {
    static String readString(Scanner input, String label) {
        System.out.println(label + ": ");
        return input.next();
    }

    static int readInteger(Scanner input, String label) {
        boolean isInvalid = true;
        int integerInput = 0;
        while (isInvalid) {
            try {
                System.out.println(label + ": ");
                integerInput = input.nextInt();
                if (integerInput > 0) {
                    isInvalid = false;
                } else {
                    System.out.println("Negative number");
                }
            } catch (InputMismatchException e) {
                System.out.println("Try again, bad input");
                input.next();
            }
        }
        return integerInput;
    }

    static long readLong(Scanner input) {
        boolean isInvalid = true;
        long longInput = 0;
        while (isInvalid) {
            try {
                System.out.println("pesel: ");
                longInput = input.nextInt();
                if (longInput > 0) {
                    isInvalid = false;
                } else {
                    System.out.println("Negative number");
                }
            } catch (InputMismatchException e) {
                System.out.println("Try again, bad input");
                input.next();
            }
        }
        return longInput;
    }
}


