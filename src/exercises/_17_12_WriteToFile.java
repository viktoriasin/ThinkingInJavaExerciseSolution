package exercises;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class _17_12_WriteToFile {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/testPackage/TestFileToWrite");
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        int lineCount = 0;
        out.write(lineCount++ + " Hey");
        out.newLine();
        out.write(lineCount++ + " Hi");
        out.newLine();
        out.write(lineCount++ +" Bye");
        out.newLine();
        out.close();
    }
}
