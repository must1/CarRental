package car.rental.data.getters;


import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTakerTest {

    @Test
    void takeStringInput() {
        Scanner scanner = new Scanner("Test");
        String expected = InputTaker.takeStringInput(scanner, "test");
        String actual = "Test";

        assertEquals(expected, actual);

    }

    @Test
    void takeIntInput() {
        Scanner scanner = new Scanner("1");
        int expected = InputTaker.takeIntInput(scanner, "test");
        int actual = 1;

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFirstValidIntegerInput() {
        Scanner scanner = new Scanner(String.format("Test%n-33%n42%n43%n"));

        int actual = InputTaker.takeIntInput(scanner, "test");

        assertThat(actual, is(equalTo(42)));
    }

    @Test
    void takeLongInput() {
        Scanner scanner = new Scanner("111111111");
        long expected = InputTaker.takeLongInput(scanner);
        long actual = 111111111;

        assertEquals(expected, actual);
    }
    @Test
    void shouldReturnFirstValidLongInput() {
        Scanner scanner = new Scanner(String.format("Test%n-33333%n1111111%n2222222%n"));
        long expected = 1111111;
        long actual = InputTaker.takeLongInput(scanner);

        assertEquals(expected, actual);
    }
}