package exercises;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class _17_16_UsingRandomAccessFile {
    static String file = "TestFileRandomAccess";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile("./src/testPackage/" + file, "r");
        for(int i = 0; i < 7; i++)
            System.out.println(
                    "Value " + i + ": " + rf.readDouble());
        System.out.println(rf.readUTF());
        rf.close();
    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile("./src/testPackage/" + file, "rw");
        rf.writeDouble(2.2);
        rf.writeBoolean(true);
        rf.writeByte(1);
        rf.writeChar('1');
        rf.writeFloat(1.2f);
        rf.writeInt(2);
        rf.writeLong(123L);
        rf.writeUTF("Hey");
        rf.seek(0);
        System.out.println(rf.readDouble());
        System.out.println(rf.readBoolean());
        System.out.println(rf.readByte());
        rf.seek(0);
        System.out.println(rf.readDouble());
        rf.seek(0);
        System.out.println(rf.read());


    }
}
