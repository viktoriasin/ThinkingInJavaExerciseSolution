package exercises;

import java.io.*;

public class _17_15_UsingDataOutputStream {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/testPackage/FileToWriteBin.bin");
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        out.writeBoolean(false);
        out.writeByte(2);
        out.writeChar('d');
        out.writeDouble(2.3);
        out.writeFloat(1.2f);
        out.writeShort(1);
        out.writeInt(11);
        out.writeUTF("dsf");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        System.out.println(in.readBoolean());
        System.out.println(in.readByte());
        System.out.println(in.readChar());
        System.out.println(in.readDouble());
        System.out.println(in.readFloat());
        System.out.println(in.readShort());
        System.out.println(in.readInt());
        System.out.println(in.readUTF());
        in.close();

    }
}
