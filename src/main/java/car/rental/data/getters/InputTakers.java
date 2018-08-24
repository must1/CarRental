package car.rental.data.getters;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputTakers {

    static String takeStringInput(Scanner input, String label) {
        while (true) {
            try {
                System.out.println(label + ": ");
                return input.next();
            } catch (InputMismatchException e) {
                System.out.println("Try again, bad input");
                input.next();
            }
        }
    }

    static int takeIntInput(Scanner input, String label) {
        while (true) {
            try {
                System.out.println(label + ": ");
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Try again, bad input");
                input.next();
            }
        }
    }

    static long takeLongInput(Scanner input) {
        while (true) {
            try {
                System.out.println("pesel" + ": ");
                return input.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Try again, bad input");
                input.next();
            }
        }
    }
}

