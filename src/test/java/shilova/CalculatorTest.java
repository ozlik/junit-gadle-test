package shilova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("должен корректно складывать числа")
    void shouldAddNumbers() {
        int a = 3;
        int b = 2;

        int c = calculator.add(a, b);

        assertEquals(5, c);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void sourceTest(int parameter) {
        int actualSum = parameter + parameter;
        int expectedSum = 2 * parameter;

        assertEquals(expectedSum, actualSum, "Суммы должны быть разными");
    }

    @ParameterizedTest
    @CsvSource({"John, Doe", "Alice, Smith"})
    void csvTest(String firstName, String lastName) {
        List<String> expectedPeople = Arrays.asList("John Doe", "Alice Smith");

        assertTrue(expectedPeople.contains(firstName + " " + lastName));
    }

    static Stream<String> provideParameters() {
        return Stream.of("One", "Two", "Three");
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void customParametersTest(String parameter) {
        List<String> expectedPeople = Arrays.asList("One", "Two", "Three");

        assertTrue(expectedPeople.contains(parameter));
    }


}