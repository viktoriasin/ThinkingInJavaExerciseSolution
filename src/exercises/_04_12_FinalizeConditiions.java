package exercises;

import java.util.Random;

public class _04_12_FinalizeConditiions {

    static class Tank {
        String name;
        boolean loaded;

        Tank(String name) {
            this.name = name;
        }

        void fillIn() {
            loaded = true;
        }

        void cleanUp() {
            loaded = false;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            if (loaded) {
                System.out.println("Error: loaded " + name);
            }
        }
    }

    public static void main(String[] args) {
        Tank t1 = new Tank("1");
        t1.fillIn();
        t1.cleanUp();
        t1 = null;
        Tank t2 = new Tank("2");
        t2.fillIn();
        t2 = null;
        System.gc(); //Почему, если мы добавим в класс строку, то это работать не будет?!

        System.out.println(new Random().nextInt());
    }
}
