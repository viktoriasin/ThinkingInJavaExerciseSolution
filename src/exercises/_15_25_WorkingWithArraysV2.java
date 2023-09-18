package exercises;

import java.util.Arrays;

import java.util.Collections;

class ConvertTo {
    public static boolean[] primitive(Boolean[] in) {
        boolean[] result = new boolean[in.length];
        for(int i = 0; i < in.length; i++)
            result[i] = in[i]; // Autounboxing
        return result;
    }
    public static char[] primitive(Character[] in) {
        char[] result = new char[in.length];
        for(int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }
    public static byte[] primitive(Byte[] in) {
        byte[] result = new byte[in.length];
        for(int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }
    public static short[] primitive(Short[] in) {
        short[] result = new short[in.length];
        for(int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }
    public static int[] primitive(Integer[] in) {
        int[] result = new int[in.length];
        for(int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }
    public static long[] primitive(Long[] in) {
        long[] result = new long[in.length];
        for(int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }
    public static float[] primitive(Float[] in) {
        float[] result = new float[in.length];
        for(int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }
    public static double[] primitive(Double[] in) {
        double[] result = new double[in.length];
        for(int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }
}

public class _15_25_WorkingWithArraysV2 {
    static class MyList {
        int[] array;
        MyList(int[] array) {
            this.array = array;
        }

        public int[] getReversed() {
            int[] res = new int[array.length];
            System.arraycopy(array, 0, res, 0, array.length);
            for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
                res[j] = array[i];
            }
            return res;
        }
    }
    public static void main(String[] args) {
        int[] aList = {1, 2, 3, 4, 5};
        System.out.println(aList.getClass().getSimpleName());
        System.out.println(Arrays.toString(aList));
        System.out.println(aList[4]);
        int[] aListV2 = new int[aList.length + 1];
        System.arraycopy(aList, 0, aListV2, 0, aList.length);
        aListV2[aListV2.length - 1] = 6;
        System.out.println(Arrays.toString(aListV2));
        int[] aListV7 = new int[aListV2.length + 2];
        System.arraycopy(aListV2, 0, aListV7, 0, aListV2.length);
        aListV7[aListV7.length - 2] = 7;
        aListV7[aListV7.length - 1] = 8;
        System.out.println(Arrays.toString(aListV7));
        int[] aSlice = new int[2];
        System.arraycopy(aList, 2, aSlice, 0, 2);
        System.out.println(Arrays.toString(aSlice));
        MyList myListV2 = new MyList(aList);
        System.out.println(myListV2.getClass().getSimpleName());
        System.out.println(Arrays.toString(myListV2.getReversed()));

    }
}


