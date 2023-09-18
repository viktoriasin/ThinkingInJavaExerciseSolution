package exercises;

class AAb {
    private int j;
    AAb(int j) {
        this.j = j;
    }
}

class Ba {
    private AAb a; // blank final; must be initialized!
    Ba() {
        a = new AAb(1);
    }

    Ba(int x) {
        a = new AAb(x);
    }
}

public class BlankFinal {
    public static void main(String[] args) {
        Ba b = new Ba(1);
        Ba bb = new Ba();
    }
}
