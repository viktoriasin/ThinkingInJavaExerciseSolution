package exercises;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

class SortedDirList {
    String[] dirList;

    private FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    SortedDirList(File file, String pattern) {
        if (pattern == null) {
            dirList = list(file);
        } else {
            dirList = list(file, pattern);
        }
        dirList = file.list();
        if (dirList != null) {
            Arrays.sort(dirList);
        }
    }

    public void printDir() {
        for (String file : dirList) {
            System.out.println(file);
        }
    }

    public String[] list(File file) {
        return file.list();
    }

    public String[] list(File file, String pattern) {
        return file.list(filter(pattern));
    }

}

public class _17_02_SortedDirList {
    public static void main(String[] args) {
        SortedDirList path = new SortedDirList(new File("./src/exercises"), null);
        path.printDir();
    }
}
