package exercises;


class LostMessageV2 extends LostMessage {

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                try {

                    lm.f();

                } finally {
                    try {
                        lm.dispose();
                    } catch (HoHumException e) {
                        System.out.println(e);
                    }
                }
            } finally {
                try {
                    lm.other();
                } catch (NotSuchImportantException e) {
                    System.out.println(e);
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}



public class _11_19_RepairLostExceptions {
    public static void main(String[] args) {
        LostMessage.main(args);
    }
}
