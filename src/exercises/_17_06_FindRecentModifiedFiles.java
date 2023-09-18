package exercises;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import testPackage.Directory;

class ProcessFiles {
    public interface Strategy {
        void process(File file) throws ParseException;
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        // Allow user to leave off extension:
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(
                                new File(arg).getCanonicalFile());
                    }
                }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException, ParseException {
        for (File file : Directory.walk(
                root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    // Demonstration of how to use it:
    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            public void process(File file) throws ParseException {
                String str = "11.08.2023 00:00";
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:ss");
                Date date = df.parse(str);
                long epoch = date.getTime();
                long lastModifiedTime = file.lastModified();
                if (lastModifiedTime > epoch) {
                    System.out.println(file);
                }
            }
        }, "java").start(args);
    }
}


public class _17_06_FindRecentModifiedFiles {
    public static void main(String[] args) {
        ProcessFiles.main(new String[] {});
    }
}
