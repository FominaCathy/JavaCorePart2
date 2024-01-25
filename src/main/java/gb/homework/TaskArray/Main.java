package gb.homework.TaskArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //количество чётных элементов массива
        int[] array = new int[]{1, 2, 3, 4, 0, 1, 0, 0};
        System.out.printf("массив: %s\n", Arrays.toString(array));
        System.out.printf(" - колво четных чисел в массиве = %d\n", ArrayMethod.countEvens(array));
        System.out.printf(" - разница между мин и мах = %d\n", ArrayMethod.maxDifference(array));
        System.out.printf(" - наличие 2х подрят нулей = %b\n", ArrayMethod.doubleZero(array));





    }
}
