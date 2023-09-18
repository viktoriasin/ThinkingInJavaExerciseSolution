package exercises;
import exercises._05_09_ConnectionManager;

public class _05_09_TestConnectionManager {
    public static void main(String[] args) {
//        cnctManager.cnct // has no access
        for (int i = 0; i <= 5; i++) {
            System.out.println(_05_09_ConnectionManager.getConnection()); // последние две должны быть null
        }
    }
}
