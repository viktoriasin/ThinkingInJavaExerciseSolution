package exercises;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class _17_07_ReadFileLineByLine {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/exercises/_16_17_SlowMap.java");
        BufferedReader source = new BufferedReader(new FileReader(file));
        LinkedList<String> data = new LinkedList<>();
        String rn;
        while (( rn = source.readLine()) != null) {
            System.out.println(rn.toLowerCase());
        }
        source.close();
//        Collections.reverse(data);
//        System.out.println(data);
    }
}
