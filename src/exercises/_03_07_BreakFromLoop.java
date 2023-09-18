package exercises;

public class _03_07_BreakFromLoop {
    public static void main(String[] args) {
        int i = 0;
        while(true) {
            if (i == 99) {
                break;
            }
            i++;
        }
    }

    static void returnFromLoop() {
        int i = 0;
        while(true) {
            if (i == 99) {
                return;
            }
            i++;
        }
    }
}
