package gb.homework.DetailWork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Backup {

    public static void bkpFiles(File parentFolder) {
        File bkp = new File(parentFolder.getPath() + "/backup");
        if (bkp.mkdir()) {
            System.out.println("folder is create");
        } else {
            System.out.println("folder NOT create");
            if (bkp.exists()) {
                System.out.println("folder is exist");
            }
        }

        for (File item : parentFolder.listFiles()) {
            if (item.isFile()) {
                try {
                    Path target = Path.of(bkp.getPath() + '/' + item.getName());
                    if (Files.exists(target)) {
                        Files.delete(target);
                    }
                    Files.copy(item.toPath(), Path.of(bkp.getPath() + '/' + item.getName()));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
