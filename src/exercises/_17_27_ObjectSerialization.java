package exercises;


import java.io.*;

class Serializable1 implements Serializable {
    private int n;
    public Serializable1(int n) { this.n = n; }
    public String toString() { return Integer.toString(n); }
}

class Serializable2 implements Serializable {
    private int n;
    private Serializable1 obj;
    public Serializable2(int n, Serializable1 obj) {
        this.n = n;
        this.obj = obj;
    }
    public String toString() { return Integer.toString(n) + " obj:"+ obj; }
}

public class _17_27_ObjectSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serializable1 s1 = new Serializable1(1);
        Serializable2 s2 = new Serializable2(2, s1);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject(s2);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        Serializable2 s3 = (Serializable2)in2.readObject();
        System.out.println(s3);
    }
}
