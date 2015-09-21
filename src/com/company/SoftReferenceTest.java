package com.company;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User1 on 8/25/2015.
 */
public class SoftReferenceTest {
    public SoftReference<ArrayList<String>> myItems = new SoftReference<ArrayList<String>>(new ArrayList<String>());

    SoftReference<String> softObject = new SoftReference<String>(randomString());
    static String ALPHABET = "QWERTYUIOPASDFGHJKLXCVBNM";
    static Random rnd = new Random();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(20*1000);
        OOM();
    }


    static String randomString() {
        return randomString(15);
    }
    static String randomString(int maxLength) {
        String result="";
        for (int i = 0; i < maxLength; i ++){
            result+= ALPHABET.charAt((int) (rnd.nextFloat()*(ALPHABET.length()-1)));
        }

        return result;
    }
    static void OOM () {
            try {
                while (true)
                    System.out.println(); //to run a project
                    // strings.add(new SoftReference<String>(randomString()));
            } catch (OutOfMemoryError e) {
                System.out.println("OOM");
            }
    }
}
