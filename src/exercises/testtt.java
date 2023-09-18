package exercises;

import java.util.Random;

public class testtt {
    public static void main(String[] args) {
        MySystem mySystem = new MySystem();

        UI ui = new UI(mySystem);

        ui.activate();

        mySystem.doSomething();
        mySystem.doSomething();
        mySystem.doSomething();
        mySystem.doSomething();
        mySystem.doSomething();

        ui.checkStatus();
    }
}


class MySystem {

    private int status = 0;

    private StatusListener listener;

    void doSomething() {
        // ...
        status = new Random().nextInt();
        if (listener != null) {
            listener.onStatusUpdate(status);
        }
        // ...
    }

    void addStatusListener(StatusListener listener) {
        this.listener = listener;
    }

    int getStatus() {
        return status;
    }
}


class UI {

    UI(MySystem system) {
        this.system = system;
    }

    private final MySystem system;

    void activate() {
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatusUpdate(int status) {
                System.out.println("Завершена проверка статуса (через листнер): " + status);
            }
        };
        system.addStatusListener(listener);
    }

    void checkStatus() {
        System.out.println("Завершена проверка статуса: " + system.getStatus());
    }
}

interface StatusListener {
    void onStatusUpdate(int status);
}
