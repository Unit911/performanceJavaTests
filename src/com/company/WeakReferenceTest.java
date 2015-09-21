package com.company;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
      static WeakReference<String> string1;

    public static void main(String[] args) throws InterruptedException {
        string1 = new WeakReference<String>(new String("1111111111111111111111111111111"));
        out();
        System.gc();
        out();

    }

    public static void out() {
        System.out.println(string1.get());
    }
}
