package gb.homework.DetailWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOField {
    private static String[] convert = new String[]{"00", "01", "10", "11"};

    public static void outputField(int[] array, File file ){
        try (FileOutputStream out = new FileOutputStream(file)) {
            for (int i = 0; i < array.length; i += 3) {
                String txt = "11" + convert[array[i]] + convert[array[i + 1]] + convert[array[i + 2]];
                out.write(Integer.parseInt(txt, 2));
            }
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static int[] inputField (File file){
        int[] inputArray = new int[9];
        try (FileInputStream inputStream = new FileInputStream(file)) {

            int i;
            int j = 0;
            while ((i = inputStream.read()) != -1) {
                String tmp = Integer.toBinaryString(i);
                for (int k = 2; k < 8; k += 2) {
                    inputArray[j] = Integer.parseInt("" + tmp.charAt(k) + tmp.charAt(k + 1),2);
                    j++;
                }
            }
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
        return inputArray;
    }
}
