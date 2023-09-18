package exercises;

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;
public class _17_23_NIOExample {
    private static final int BSIZE = 1024;

    public static boolean isPrintableCharacter(char ch) {
        if ((int) ch <= 31) {
            return false;
        }
        return true;
    }

    public static void printBuffer(ByteBuffer buff) {
        buff.flip();
        while(buff.hasRemaining()) {
            char ch = (char) buff.get();
            if (isPrintableCharacter(ch)) {
                System.out.print(ch);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        FileChannel fc =
                new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some \ttext\n".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        printBuffer(buff);
        fc.close();
//        buff.flip();
//        // Doesn’t work:
//        System.out.println(buff.asCharBuffer());
//        // Decode using this system’s default Charset:
//        buff.rewind();
//        String encoding = System.getProperty("file.encoding");
//        System.out.println("Decoded using " + encoding + ": "
//                + Charset.forName(encoding).decode(buff));
//        // Or, we could encode with something that will print:
//        fc = new FileOutputStream("data2.txt").getChannel();
//        fc.write(ByteBuffer.wrap(
//                "Some text".getBytes("UTF-16BE")));
//        fc.close();
//        // Now try reading again:
//        fc = new FileInputStream("data2.txt").getChannel();
//        buff.clear();
//        fc.read(buff);
//        buff.flip();
//        System.out.println(buff.asCharBuffer());
//        // Use a CharBuffer to write through:
//        fc = new FileOutputStream("data2.txt").getChannel();
//        buff = ByteBuffer.allocate(24); // More than needed
//        buff.asCharBuffer().put("Some text");
//        fc.write(buff);
//        fc.close();
//        // Read and display:
//        fc = new FileInputStream("data2.txt").getChannel();
//        buff.clear();
//        fc.read(buff);
//        buff.flip();
//        System.out.println(buff.asCharBuffer());
//        System.out.println((int) 'a');
//        System.out.println((int) 'A');
//        System.out.println((int) '\f');

    }
}

