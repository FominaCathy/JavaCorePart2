package gb.homework.DetailWork;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        // backup всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup
        Backup.bkpFiles(new File("src/main/java/gb/homework/DetailWork"));
        //Записать в файл 9 значений так, чтобы они заняли три байта.
        saveField();

    }

    /**
     * Записать в файл 9 значений так, чтобы они заняли три байта.
     */
    private static void saveField() {
        int[] array = new int[]{0, 1, 2, 3, 3, 2, 1, 0, 1};

        File file = new File("storage.txt");
        IOField.outputField(array, file);
        try (FileInputStream inputStream = new FileInputStream(file)) {
            System.out.println("размер файла (байт) = " + inputStream.available());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("восстановим данные из файла:");
        int[] inputArray = IOField.inputField(file);
        System.out.println(Arrays.toString(inputArray));
    }
}
