package exercises;

public class _04_05_DogOverloadedConstructor {
    static class Dog {
        Dog(char i) {
            System.out.println("This is char here!");
        }
        Dog(byte i) {
            System.out.println("This is byte here!");
        }
        Dog(short i) {
            System.out.println("This is short here!");
        }
        Dog(int i) {
            System.out.println("This is int here!");
        }
        Dog(long i) {
            System.out.println("This is long here!");
        }
        Dog(float i) {
            System.out.println("This is float here!");
        }
        Dog(double i) {
            System.out.println("This is double here!");
        }
        Dog(double i,  float j) {
            System.out.println("This is double-float here!");
        }
        Dog(float i,  double j) {
            System.out.println("This is float-double here!");
        }
    }

    public static void main(String[] args) {
        byte a = 1;
        short b = 2;
        long c = 1L;
        float d = 2F;
        double e = 3;
        new Dog('s');
        new Dog(a);
        new Dog(b);
        new Dog(12);
        new Dog(c);
        new Dog(d);
        new Dog(e);
        new Dog(d, e);
        new Dog(e, d);
    }
}
