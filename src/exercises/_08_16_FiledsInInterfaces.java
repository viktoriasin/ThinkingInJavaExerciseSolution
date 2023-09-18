package exercises;

interface S {
    int X = 2;
    String S = "I'm a CONST!!!";

}

public class _08_16_FiledsInInterfaces implements S {
    public static void main(String[] args) {
        System.out.println(_08_16_FiledsInInterfaces.X);
        System.out.println(_08_16_FiledsInInterfaces.S);
//        _08_16_FiledsInInterfaces.X = 3; // не можем поменять static final переменные в интерфейсе!
//        _08_16_FiledsInInterfaces.S = "CONST CANNOT CHANGE!" // не можем поменять static final переменные в интерфейсе!
    }
}
