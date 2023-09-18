package exercises;

import java.util.SortedMap;

class BaseOverloadeClass {
    char CharReturn(char ch) {
        System.out.println(ch);
        return ch;
    }

    int IntReturn(int i) {
        System.out.println(i);
        return i;
    }

    float FloatReturn(float f) {
        System.out.println(f);
        return f;
    }

    void custom() {
        System.out.println("Custom of BaseOverloadeClass!");
    }
}

class ClassV2 extends BaseOverloadeClass {

    void custom() {
        System.out.println("Custom of ClassV2!"); // overriding
    }

    void CharReturn() {
        System.out.println("CharReturn of ClassV2!"); // overloading
    }



}

public class _06_13_OverridingVsOverloading {

    public static void main(String[] args) {
        ClassV2 cl = new ClassV2();
        cl.custom();
        cl.CharReturn();
        cl.CharReturn('d');
        cl.IntReturn(1);
        cl.FloatReturn(1.2f);
    }
}
