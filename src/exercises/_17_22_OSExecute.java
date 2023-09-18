package exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
}

class OSExecute {
    public static List<String> command(String command) {
        boolean err = false;
        List<String> result = new ArrayList<>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                result.add(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            // Report errors and return nonzero value
            // to calling process if there are problems:
            while ((s = errors.readLine()) != null) {
                result.add(s);
                err = true;
            }
        } catch (Exception e) {
            // Compensate for Windows 2000, which throws an
            // exception for the default command line:
            if (!command.startsWith("CMD /C")) command("CMD /C " + command);
            else throw new RuntimeException(e);
        }
        if (err) {
            throw new OSExecuteException("Errors executing " + command);
        }
        return result;
    }
}

public class _17_22_OSExecute {
    public static void main(String[] args) {
        System.out.println(OSExecute.command("ls -lh"));
    }
}
