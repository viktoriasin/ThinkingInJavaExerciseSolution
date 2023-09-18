package exercises;

import testPackage.Directory;

import java.io.File;


public class _17_04_FindSizeOfDirectories {
    public static void main(String[] args) {

        Directory.TreeInfo data = Directory.walk(".");
        long totalSize = 0;
        for (File file : data.files) {
            totalSize += file.length();
        }

        System.out.println(totalSize);

    }
}
