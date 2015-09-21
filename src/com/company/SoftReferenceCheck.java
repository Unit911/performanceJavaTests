package com.company;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Random;

public class SoftReferenceCheck {
    static ArrayList<String> strings = new ArrayList<String>(); //array for OOM creation
    static String ALPHABET = "QWERTYUIOPASDFGHJKLXCVBNM";           //using this when generating random strings
    static Random rnd = new Random();                               //
    static SoftReference<String> softReferenceVar;         //object with soft reference
    static Runtime runtime = Runtime.getRuntime();         //to show memory status

    public static void main(String[] args) throws InterruptedException {
        softReferenceVar = new SoftReference<String>(randomString()); //generation of new object
        Thread.sleep(20*1000);                                              //some sleep time to connect with profiler
        System.out.println("Value is: " + softReferenceVar.get());
        System.gc();                                                    //GC call
        System.out.println("Value after first GC: " + softReferenceVar.get());
        System.out.println("========================");
        for (int i = 0; i < 100; i++) {
            softReferenceVar = new SoftReference<String>(randomString());
            System.out.println("Value is: " + softReferenceVar.get());
            System.out.println("Free memory: "+runtime.freeMemory());
            OOM(); //function for OOM error generation
            System.out.println("========================");
        }

    }

    static String randomString() { //function just generate random strings of MAXLENGTH size
        int MAXLENGTH = 15;
        String result="";
        for (int i = 0; i < MAXLENGTH; i ++){
            result+= ALPHABET.charAt((int) (rnd.nextFloat()*(ALPHABET.length()-1)));
        }

        return result;
    }
    static void OOM () {
            try {
                while (softReferenceVar.get() != null)       //generate and keep in memory strings
                    strings.add(randomString());            //while object with soft reference present in the heap
                strings = new ArrayList<String>();      //if no OOM was thrown clear the array of strings
                System.out.println("NOT OOM: "+softReferenceVar.get());
                System.out.println("Free memory: "+runtime.freeMemory());

            } catch (OutOfMemoryError e) {
                System.out.println("OOM: "+softReferenceVar.get());
                strings = new ArrayList<String>();
                System.gc();
            }
    }
}
