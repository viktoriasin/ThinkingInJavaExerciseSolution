package exercises;

public class _04_15_InstanceInitialization {
    String g;
    {
        g = "dfg";
    }

    public static void main(String[] args) {
        _04_15_InstanceInitialization h = new _04_15_InstanceInitialization();
        System.out.println(h.g);
    }
}
