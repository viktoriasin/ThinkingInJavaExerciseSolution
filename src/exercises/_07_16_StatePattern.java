package exercises;

enum CaseStatus {
    DINNER,
    ALARM,
    HAPPY
}

class AlertStatus {
    public void signal() {
    }

    ;
}

class AlarmStatus extends AlertStatus {
    public void signal() {
        System.out.println("Alarm!");
    }
}

class DinnerStatus extends AlertStatus {
    public void signal() {
        System.out.println("Dinner!");
    }
}

class HappyStatus extends AlertStatus {
    public void signal() {
        System.out.println("Happy!");
    }
}

class Starhip {
    AlertStatus status = new DinnerStatus();

    private AlertStatus getStatus(CaseStatus caseStatus) {
        switch (caseStatus) {
            default:
            case HAPPY:
                return new HappyStatus();
            case ALARM:
                return new AlarmStatus();
        }
    }

    public void change(CaseStatus caseStatus) {
        status = getStatus(caseStatus);
    }

    public void notifyShip() {
        status.signal();
    }
}


public class _07_16_StatePattern {
    public static void main(String[] args) {
        Starhip st = new Starhip();
        st.notifyShip();
        CaseStatus cs = CaseStatus.HAPPY;
        st.change(cs);
        st.notifyShip();
    }
}
