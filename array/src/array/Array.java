/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan
 */
public class Array {

    public static volatile int arrhere[] = new int[9];
    static int index = 0;

    public Array() {
    }

    public static synchronized void add(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arrhere[index++] = arr[i];

        }

    }

    public void print() {
        for (int i = 0; i < arrhere.length; i++) {
            System.out.println(arrhere[i]);
        }

    }

    public static void main(String[] args) {
System.out.println("Classloader of this class:"+ArrayList.class.getClassLoader()); 
        Array arr = new Array();
        int arr1[] = {1, 2, 3};
        int arr2[] = {4, 5, 6};
        int arr3[] = {7, 8, 9};
        Thread thread1 = new Thread(() -> arr.add(arr1));

        Thread thread2 = new Thread(() -> arr.add(arr2));
        Thread thread3 = new Thread(() -> arr.add(arr3));

        thread1.start();

        thread2.start();

        thread3.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Array.class.getName()).log(Level.SEVERE, null, ex);
        }
        arr.print();

    }

}
