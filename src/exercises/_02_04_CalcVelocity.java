package exercises;

public class _02_04_CalcVelocity {


    static float calc(float distance, int time_) {
        return distance / time_;
    }

    public static void main(String[] args) {

        float distance = 4.56F;
        int time_ = 12;

        System.out.println(calc(distance, time_));
    }
}
