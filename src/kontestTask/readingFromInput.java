package kontestTask;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class readingFromInput  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        String[] strings = input.split(" ");

        System.out.println(Integer.parseInt(strings[0]) + Integer.parseInt(strings[1]));
//        System.out.println(Long.parseLong(strings[0]) + Long.parseLong(strings[1]));
    }
}