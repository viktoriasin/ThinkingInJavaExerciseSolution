package exercises;

interface Payable<T> {}
class EmployeeV171 implements Payable {}
class HourlyV171 extends EmployeeV171
        implements Payable {} // compiles only when removing all the generics

public class _14_31_MultipleInterfaceVariants {
    public static void main(String[] args) {

    }
}
