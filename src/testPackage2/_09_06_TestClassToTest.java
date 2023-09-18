package testPackage2;

import testPackage._09_06_Test;

public class _09_06_TestClassToTest {
    public static void main(String[] args) {
        _09_06_TestClass j = new _09_06_TestClass();
        _09_06_Test t = j.new InsideTestClass();
    }
}
