package exercises;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.*;
import java.nio.charset.*;

class _17_26_JGreapUsingMemoryMappedFiles {
    public static void main(String[] args) throws Exception {

        Pattern p = Pattern.compile("SlowMap");
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        FileChannel fc = new FileInputStream("./src/exercises/_16_17_SlowMap.java").getChannel();
        ByteBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
        String encoding = System.getProperty("file.encoding");
        CharBuffer ch =  Charset.forName(encoding).decode(ib);
        String[] lines = ch.toString().split("\n");
        fc.close();
        for(String line : lines) {
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
    }
}


