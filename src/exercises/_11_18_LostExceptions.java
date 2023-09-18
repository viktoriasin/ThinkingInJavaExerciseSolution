package exercises;

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}
class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

class NotSuchImportantException extends Exception {
    public String toString() {
        return "A not such important exception";
    }
}

class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    void other() throws NotSuchImportantException {
        throw new NotSuchImportantException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                try {

                    lm.f();

                } finally {
                    lm.dispose();
                }
            } finally {
            lm.other();
        }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

public class _11_18_LostExceptions {
    public static void main(String[] args) {
        LostMessage.main(args);
    }
}
