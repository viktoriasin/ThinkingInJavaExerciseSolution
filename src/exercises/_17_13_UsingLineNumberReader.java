package exercises;

import java.io.*;

public class _17_13_UsingLineNumberReader {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/testPackage/TestFileToWrite");
        LineNumberReader in = new LineNumberReader(new FileReader(file));
        String s;
        while ((s = in.readLine()) != null) System.out.println(in.getLineNumber());
    }
}
