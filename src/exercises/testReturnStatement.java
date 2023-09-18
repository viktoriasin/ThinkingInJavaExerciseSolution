package exercises;

public class testReturnStatement {
    static int test(int testval, int begin, int end) {
        if (testval < end && testval > begin) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(test(2, 1, 4));
        System.out.println(test(2, 3, 4));

    }
}
