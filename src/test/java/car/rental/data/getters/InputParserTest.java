package car.rental.data.getters;


import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void takeStringInput() {
        Scanner scanner = new Scanner("Test");
        String expected = InputParser.readString(scanner, "test");
        String actual = "Test";

        assertEquals(expected, actual);
    }

    @Test
    void takeIntInput() {
        Scanner scanner = new Scanner("1");
        int expected = InputParser.readInteger(scanner, "test");
        int actual = 1;

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFirstValidIntegerInput() {
        Scanner scanner = new Scanner(String.format("Test%n-33%n42%n43%n"));

        int actual = InputParser.readInteger(scanner, "test");

        assertThat(actual, is(equalTo(42)));
    }

    @Test
    void takeLongInput() {
        Scanner scanner = new Scanner("111111111");
        long expected = InputParser.readLong(scanner);
        long actual = 111111111;

        assertEquals(expected, actual);
    }
    @Test
    void shouldReturnFirstValidLongInput() {
        Scanner scanner = new Scanner(String.format("Test%n-33333%n1111111%n2222222%n"));
        long expected = 1111111;
        long actual = InputParser.readLong(scanner);

        assertEquals(expected, actual);
    }


}