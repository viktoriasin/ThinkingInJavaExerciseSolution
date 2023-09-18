package exercises;

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("Board Game constructor");
    }
}

class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
}

public class _06_06_BaseClassConstructorWithArgs {
    public static void main(String[] args) {
        Chess ch = new Chess();
    }
}

