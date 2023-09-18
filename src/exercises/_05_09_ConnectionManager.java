package exercises;


class Connection {
    protected Connection() {
    }
}

public class _05_09_ConnectionManager {
    private static Connection[] cnct = new Connection[5];
    private static int cnctCounter;
    static {
        for (int i = 0; i < cnct.length; i++) {
            cnct[i] = new Connection();
            cnctCounter = 0;
        }
    }

    public static Connection getConnection() {
        if (cnctCounter == cnct.length) {
            return null;
        }
        return cnct[cnctCounter++];
    }
}
