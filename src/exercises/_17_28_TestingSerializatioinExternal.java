package exercises;

import java.io.*;


class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 Constructor");
    }


    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Blip1.writeExternal");
    }
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}
class BlipCheck implements Externalizable {
    BlipCheck() {
        print("BlipCheck Constructor");
    }

    private void print(String blip2Constructor) {

    }

    public void writeExternal(ObjectOutput out)
            throws IOException {
        print("BlipCheck.writeExternal");
    }
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("BlipCheck.readExternal");
    }
}

class Blips {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        BlipCheck b2 = new BlipCheck();
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("Blips.out"));
        System.out.println("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        b1 = (Blip1)in.readObject();
        // OOPS! Throws an exception:
        System.out.println("Recovering b2:");
        b2 = (BlipCheck)in.readObject();
    }
}

public class _17_28_TestingSerializatioinExternal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blips.main(null);
    }
}
