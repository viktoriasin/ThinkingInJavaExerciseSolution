package exercises;



class ConstructionExceptionV2 extends Exception {}

class NeedsCleanupV2 {
    // Construction can fail:
    public NeedsCleanupV2() throws ConstructionExceptionV2 {}
}

class NeedsCleanupV3 extends NeedsCleanupV2 {

    public NeedsCleanupV3() throws ConstructionExceptionV2 {
//        try{
//
//        } catch (ConstructionExceptionV2 e) { // нельзя в классе-потомке поймать исключение, выброшенное в классе наследнике
//            System.out.println("Test");
//        }
    }
}


public class _11_21_ExceptionInConstructorExample {
}
