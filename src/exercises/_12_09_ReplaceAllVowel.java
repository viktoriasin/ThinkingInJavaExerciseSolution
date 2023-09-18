package exercises;

public class _12_09_ReplaceAllVowel {
    public static void main(String[] args) {
        String knights =
                "Then, when you have found the shrubbery, you must " +
                        "cut down the mightiest tree in the forest... " +
                        "with... a herring!";

        System.out.println(knights.replaceAll("[aouiey]", "_"));
    }
}
