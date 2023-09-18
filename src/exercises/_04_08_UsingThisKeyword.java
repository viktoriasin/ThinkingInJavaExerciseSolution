package exercises;

public class _04_08_UsingThisKeyword {
    static class UsingThis {
        void First() {
            Second();
            this.Second(); // don't use this it is not a good practise
        }
        void Second() {
        }
     }

    public static void main(String[] args) {
        new UsingThis().First();
    }
}
