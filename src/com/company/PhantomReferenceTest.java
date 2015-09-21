package com.company;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User1 on 9/9/2015.
 */
public class PhantomReferenceTest {
    static String ALPHABET = "QWERTYUIOPASDFGHJKLXCVBNM";
    static Random rnd = new Random();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("waiting for 20 sec");
        System.out.println("time to connect with profiler");
        Thread.sleep(20000);

        ReferenceQueue q = new ReferenceQueue();

        ArrayList list = new ArrayList();
        list.add(randomString()); //object allocated in memory



        PhantomReference pr = new PhantomReference(list.get(0), q); //phantom reference is created


        System.out.println("the string is "+list.get(0));
        System.out.println("poll: "+q.poll()); //null - as object is not rdy for finalization;
        System.out.println("pr.get(): "+pr.get()); //this should always return null
        System.out.println("the  object is: "+list.get(0)); //object string
        System.out.println("initial state");
        System.out.println("waiting for 20 sec");
        System.out.println("take a snapshot");
        Thread.sleep(20000);

        list.remove(0); //object should become not strong reachable (soft/weak)
        System.out.println("===================================");
        System.out.println("item removed from the list");
        System.out.println("waiting for 20 sec");
        System.out.println("take a snapshot");
        Thread.sleep(20000);

        System.gc(); //object should be removed
        System.out.println("GC done");
        System.out.println("===================================");
        System.out.println("After GC:");
        System.out.println("list length: "+list.size()); //make sure there is no elements in the list
        System.out.println("poll: "+q.poll());      //reference addr
        System.out.println("pr.get(): "+pr.get()); //always null


        System.out.println("waiting for 20 sec");
        System.out.println("take a snapshot");
        Thread.sleep(20000);

        System.gc();
        System.out.println("===================================");
        System.out.println("After another GC");
        System.out.println("waiting for 20 sec");
        System.out.println("take another snapshot");
        Thread.sleep(20000);

        q = null;
        System.gc();
        System.out.println("q is null.After another GC");
        System.out.println("waiting for 20 sec");
        System.out.println("take another snapshot");
        Thread.sleep(20000);


    }
    static String randomString() { //function just generate random strings of MAXLENGTH size
        int MAXLENGTH = 15;
        String result = "";
        for (int i = 0; i < MAXLENGTH; i++) {
            result += ALPHABET.charAt((int) (rnd.nextFloat() * (ALPHABET.length() - 1)));
        }
        return result;
    }

}
