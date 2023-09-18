package exercises;

public class _05_06_ManipulateProtectedData {
    public static void main(String[] args) {
        _05_04_UsingProtectedFileds.s = "X"; // can modify protected field of the class!
        _05_04_UsingProtectedFileds.printS();
    }
}
