package car.rental.data.getters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputTaker {
    static String takeStringInput(Scanner input, String label) {
        System.out.println(label + ": ");
        return input.next();
    }

    static int takeIntInput(Scanner input, String label) {
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

    static long takeLongInput(Scanner input) {
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


