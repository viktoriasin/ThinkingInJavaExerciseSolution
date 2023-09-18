package exercises;


public class _02_05_DogMain {
    public static void main(String[] args) {
        _02_05_Dog dog1 = new _02_05_Dog();
        dog1.name = "spot";
        dog1.syas = "Ruff!";

        _02_05_Dog dog2 = new _02_05_Dog();
        dog2.name = "scruffy";
        dog2.syas = "Wurf";

        System.out.println("Dog1 name is: " + dog1.name + " Dog1 says: " + dog1.syas);
        System.out.println("Dog2 name is: " + dog2.name + " Dog2 says: " + dog2.syas);

        _02_05_Dog dog3 = dog1;
        System.out.println(dog3 == dog1);
        System.out.println(dog3.equals(dog1));

        System.out.println(dog3 == dog2);
        System.out.println(dog3.equals(dog2));



    }
}
