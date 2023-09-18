package exercises;

import java.util.*;

class Receipt {
    private final Formatter f = new Formatter(System.out);

    private final int widthFirstCol;
    private final int widthSecondCol;
    private final int widthThirdCol;

    private double total = 0;

    Receipt(int widthFirstCol, int widthSecondCol, int widthThirdCol) {
        this.widthFirstCol = widthFirstCol;
        this.widthSecondCol = widthSecondCol;
        this.widthThirdCol = widthThirdCol;
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt(15, 5, 10);
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }

    private void printTitle() {
        String ruleFormat = makeFormatString("%-", "s %", "s %", "s\n");
        f.format(ruleFormat, "Item", "Qty", "Price");
        f.format(ruleFormat, "----", "---", "-----");
    }

    private void print(String name, int qty, double price) {
        String ruleFormat = makeFormatString("%-", ".15s %", "d %", ".2f\n");
        f.format(ruleFormat, name, qty, price);
        total += price;
    }

    private void printTotal() {
        String ruleFormat1 = makeFormatString("%-", "s %", "s %", ".2f\n");
        String ruleFormat2 = makeFormatString("%-", "s %", "s %", "s\n");
        f.format(ruleFormat1, "Tax", "", total * 0.06);
        f.format(ruleFormat2, "", "", "-----");
        f.format(ruleFormat1, "Total", "", total * 1.06);
    }

    private String makeFormatString(String s01, String s12, String s23, String s34) {
        return s01 + widthFirstCol + s12 + widthSecondCol + s23 + widthThirdCol + s34;
    }
}

public class _12_04_FormatterClass {
    public static void main(String[] args) {
        Receipt.main(args);
    }
}
