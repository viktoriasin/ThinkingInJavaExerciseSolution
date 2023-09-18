package exercises;
import java.util.*;

public class _12_05_TryingDifferentFormatSpecifiers {
    public static void main(String[] args) {

        Formatter formatter = new Formatter(System.out);
        System.out.println("TRYING FORMAT SPECIFIERS FOR INTEGER");
        formatter.format("% d\n", 111);
        formatter.format("%+d\n", -111);
        formatter.format("%+d\n", 111);
        formatter.format("%,d\n", 111111111);
        formatter.format("%15d\n", 111111111);
        formatter.format("%-15d\n", 111111111);
        formatter.format("%+-,15d\n", 111111111);
        System.out.println(formatter);

        System.out.println("TRYING FORMAT SPECIFIERS FOR BOOLEAN");
        formatter.format("%15.3b\n", true);
        System.out.println(formatter);

        System.out.println("TRYING FORMAT SPECIFIERS FOR STRING");
        Formatter formatter2 = new Formatter(System.out);
        formatter2.format("%-15.3s\n", "Hello!");
        System.out.println(formatter2);

        System.out.println("TRYING FORMAT SPECIFIERS FOR FLOAT");
        Formatter formatter3 = new Formatter(System.out);
        formatter3.format("%+-,15.3f\n", 12.34354634563546F);
        formatter3.format("%+-15.3e\n", 12.34354634563546F);
        System.out.println(formatter3);

        System.out.println("TRYING FORMAT SPECIFIERS FOR FLOAT");
        Formatter formatter4 = new Formatter(System.out);
        formatter4.format("%12c\n", '\u0061');
        System.out.println(formatter4);


        System.out.println("TRYING FORMAT SPECIFIERS FOR HEX");
        Formatter formatter5 = new Formatter(System.out);
        formatter5.format("%-12x\n", 0x345);
        System.out.println(formatter5);


    }
}
