package exercises;

public class _03_08_SwitchCase {
    public static void main(String[] args) {
        String[] data = {"winter",
                "autumn",
                "summer",
                "spring"};
        for (String s: data) {
            switch (s) {
                case "autumn":
                    System.out.println(s);
                    break;
                case "winter":
                    System.out.println(s);
                    break;
                case "summer":
                    System.out.println(s);
                    break;
                case "spring":
                    System.out.println(s);
                    break;
            }
        }
    }
}
