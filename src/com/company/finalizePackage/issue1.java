//package com.company.finalizePackage;
//
//import java.util.ArrayList;
//import java.util.Random;
//
///**
// * Created by User1 on 9/11/2015.
// */
//public class issue1 {
//    static String ALPHABET = "QWERTYUIOPASDFGHJKLXCVBNM";
//    static Random rnd = new Random();
//
//    public static void main(String[] args) {
//
//    }
//
//
//    static String randomString() { //function just generate random strings of MAXLENGTH size
//        int MAXLENGTH = 15;
//        String result="";
//        for (int i = 0; i < MAXLENGTH; i ++){
//            result+= ALPHABET.charAt((int) (rnd.nextFloat()*(ALPHABET.length()-1)));
//        }
//
//        return result;
//    }
//    static void OOM () {
//        try {
//            while (softReferenceVar.get() != null)       //generate and keep in memory strings
//                strings.add(randomString());            //while object with soft reference present in the heap
//            strings = new ArrayList<String>();      //if no OOM was thrown clear the array of strings
//            System.out.println("NOT OOM: "+softReferenceVar.get());
//            System.out.println("Free memory: "+runtime.freeMemory());
//
//        } catch (OutOfMemoryError e) {
//            System.out.println("OOM: "+softReferenceVar.get());
//            strings = new ArrayList<String>();
//            System.gc();
//        }
//    }
//}
