package gb.homework.TaskArray;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayMethod {
    /**
     * метод возвращает количество чётных элементов массива.
     *
     * @param array - массив целых чисел
     * @return кол-во четных элементов в массиве
     */

    public static int countEvens(int[] array) {
        return (int) Arrays.stream(array).filter(x -> x % 2 == 0).count();
    }

    /**
     * возвращаtn разницу между самым большим и самым маленьким элементами массива
     *
     * @param array - массив целых чисел
     * @return разница между самым большим и самым маленьким элементами массива
     */

    public static int maxDifference(int[] array) {

        return Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt();
    }


    /**
     * возвращающает истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
     *
     * @param array
     * @return
     */
    public static boolean doubleZero(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0 && array[i + 1] == 0) {
                return true;
            }
        }
        return false;

    }
}
