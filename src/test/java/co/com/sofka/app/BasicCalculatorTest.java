package co.com.sofka.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })

    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several multiplications")
    @ParameterizedTest(name = "{0} X {1} = {2}")
    @CsvSource({
            "0,    10,   0",
            "1,    2,   2",
            "4,  50, 200",
            "2,  7, 14"
    })
    public void severalMutiplications(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " x " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several substracts")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    10,   -10",
            "1,    2,   -1",
            "150,  50, 100",
            "2,  2, 0"
    })
    public void severalSubstracts(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.substract(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divitions")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0,    10,   0",
            "100,    10,   10",
            "150,  15, 10",
            "35,  4, 8.75",
    })
    public void severalDivitions(Long first, Long second, double expectedResult) {
        assertEquals(expectedResult, basicCalculator.div(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing divideing 0")
    @ParameterizedTest(name = "{0} / {1}")
    @CsvSource({
            "0,    0",
            "100,    0,   0",
            ""
    })
    public void testingDivitionBetweenZero(Long first, Long second) {
        var response = assertThrows(RuntimeException.class, ()->{
            Double result = basicCalculator.div(first, second);
        });
        Assertions.assertEquals("Ningun numero puede ser dividido entre 0", response.getMessage());
    }
}
