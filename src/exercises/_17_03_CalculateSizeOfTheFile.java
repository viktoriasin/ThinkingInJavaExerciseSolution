package exercises;

import java.io.File;
import java.util.Objects;

public class _17_03_CalculateSizeOfTheFile {
    public static void main(String[] args) {
        // "./src/exercises/_16_17_SlowMap.java"
        File dir = new File("./src/exercises/");
        long totalSize = 0;
        for (String file : Objects.requireNonNull(dir.list())) {
            totalSize += new File("./src/exercises/" + file).length();
        }
        System.out.println(totalSize);
    }
}
