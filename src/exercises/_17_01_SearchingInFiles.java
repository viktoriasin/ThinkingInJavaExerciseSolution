package exercises;
import testPackage.TextFile;

import java.util.regex.*;
import java.io.*;

import java.util.*;

class DirList {
    public static void main(String[] args) {

        File path = new File("./src/exercises");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}

// ищет файлы, содержимое которых содержит ключевые слова, переданные через аргументы
class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name) {
        TextFile file = new TextFile("./src/exercises/" + name);
        for (String line : file) {

            if (pattern.matcher(line).find()) {
                return true;
            }
        }
        return false;
    }
}

public class _17_01_SearchingInFiles {
    public static void main(String[] args) {
        DirList.main(new String[] {"SlowMap"});
    }
}
