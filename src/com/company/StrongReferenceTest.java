package com.company;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class StrongReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayList <Integer> strings = new ArrayList<Integer>();
        int i=0;
        while (true) {
            Thread.sleep(1);
            for(int j=1;j<=100;j++){
                strings.add(i+j);
            }
            i++;
        }

    }
}
