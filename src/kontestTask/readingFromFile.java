package kontestTask;


import java.io.*;

public class readingFromFile {
    public static void main(String[] args) {
        String s;
        String result = null;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while ((s = br.readLine()) != null) {
                String[] arr = s.split(" ");
                Integer a = Integer.parseInt(arr[0]);
                Integer b = Integer.parseInt(arr[1]);
                result = String.valueOf(a + b);
                System.out.println(s);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            bw.write(result);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}