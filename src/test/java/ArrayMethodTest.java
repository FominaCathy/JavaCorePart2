import gb.homework.TaskArray.ArrayMethod;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayMethodTest {

    @ParameterizedTest(name = "{index} - array: {0}, res = {1}")
    @MethodSource()
    @DisplayName("check count evens")
    @Tag("unit")
    void countEvensValid(int[] array, int count) {
        assertEquals(count, ArrayMethod.countEvens(array));
    }

    static Stream<Arguments> countEvensValid() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 2),
                Arguments.of(new int[]{1, 3, 3, -4}, 1),
                Arguments.of(new int[]{1, -1, 3, 5}, 0));
    }

    @ParameterizedTest(name = "{index} - array: {0}, res = {1}")
    @MethodSource()
    @DisplayName("check max difference")
    @Tag("unit")
    void maxDifferenceValid(int[] array, int difference) {
        assertEquals(difference, ArrayMethod.maxDifference(array));
    }

    static Stream<Arguments> maxDifferenceValid() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 3),
                Arguments.of(new int[]{1, 3, 3, -4}, 7),
                Arguments.of(new int[]{1, -1, 3, 5}, 6));

    }

    @ParameterizedTest(name = "{index} - array: {0}, res = {1}")
    @MethodSource()
    @DisplayName("check double zero")
    @Tag("integration")
    void doubleZeroValid(int[] array, boolean res) {
        assertEquals(res, ArrayMethod.doubleZero(array));
    }

    static Stream<Arguments> doubleZeroValid() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 3}, false),
                Arguments.of(new int[]{1, 1, 0, 3, 0}, false),
                Arguments.of(new int[]{0, 1, 0, 3}, false),
                Arguments.of(new int[]{0, 0, 1, 3}, true),
                Arguments.of(new int[]{3, 1, 0, 0}, true),
                Arguments.of(new int[]{3, 1, 0, 0, 1}, true)
        );
    }
}
