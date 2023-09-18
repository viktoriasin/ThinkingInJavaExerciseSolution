package exercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class _17_25_BufferAllocateDirect {
    private static final int BSIZE = 1024;

    public static void testReadingAndWriting() throws IOException {
        FileChannel in = new FileInputStream("dataTestIn.txt").getChannel();
        FileChannel out = new FileOutputStream("dataTestOut.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

        while (in.read(buffer) != -1) {
            buffer.flip(); // Prepare for writing
            out.write(buffer);
            buffer.clear();  // Prepare for reading
        }
    }

    public static void testReadingAndWritingDirect() throws IOException {
        FileChannel in = new FileInputStream("dataTestIn.txt").getChannel();
        FileChannel out = new FileOutputStream("dataTestOut.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(BSIZE);

        while (in.read(buffer) != -1) {
            buffer.flip(); // Prepare for writing
            out.write(buffer);
            buffer.clear();  // Prepare for reading
        }
    }

    public static void main(String[] args) throws IOException {
        try (FileOutputStream file = new FileOutputStream("dataTestIn.txt") ) {
            file.write("qweqwe".getBytes(StandardCharsets.UTF_16));
        } catch (IOException e) {
            e.printStackTrace();
        }

        long start = System.nanoTime();
        testReadingAndWriting();
        double duration = System.nanoTime() - start;
        System.out.format("%.2f\n", duration);

        long start2 = System.nanoTime();
        testReadingAndWritingDirect();
        double duration2 = System.nanoTime() - start2;
        System.out.format("%.2f\n", duration2);
    }

}
