package exercises;

import java.util.Scanner;

class InputData {
    private int i;
    private double d;
    private long l;
    private float f;
    private String s;

    InputData(String text) {
        Scanner console = new Scanner(text);
        int i = console.nextInt();
        long l = console.nextLong();
        float f = console.nextFloat();
        double d = console.nextDouble();
        String s = console.nextLine();
        this.s = s;
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
    }

    public String toString() {
        return String.format("%d %d %f %f %s", i, l, f, d, s);
    }

}

public class _12_20_ScannerUsage {
    public static void main(String[] args) {
        System.out.println(new InputData("12 12 12,3 2312,1 Sdef").toString());
    }
}
