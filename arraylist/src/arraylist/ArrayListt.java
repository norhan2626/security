/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayList;

import java.util.*;

/**
 *
 * @author Dan
 */
public class ArrayListt {

    public static volatile ArrayList<Integer> listnew = new ArrayList<Integer>();
    static int index = 0;

    public static synchronized void add(ArrayList<Integer> array) {
         //for (int i = 0; i < listnew.size(); i++) {
           //listnew.add( array.get(i)); 
           listnew.addAll(array);
           
           
    }

    public void print() {

        for (int i = 0; i < listnew.size(); i++) {
            System.out.println(listnew.get(i) + " ");
          
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ArrayListt arr = new ArrayListt();
System.out.println("Classloader of this class:"+ArrayListt.class.getClassLoader()); 
        //   int[] list1 = {1, 2, 3};
        ArrayList<Integer> values = new ArrayList<>();
//        for (int id : list1) {
//            values.add(id);
//        }
        values.add(10);
        values.add(20);
        values.add(30);

        //   int[] list2 = {1, 2, 3};
        ArrayList<Integer> val2 = new ArrayList<>();

//        for (int id : list2) {
//            val2.add(id);
//        }
        val2.add(40);
        val2.add(50);
        val2.add(60);
        int[] list3 = {1, 2, 3};
        ArrayList<Integer> val3 = new ArrayList<>();

//        for (int id : list3) {
//            val3.add(id);
//        }
        val3.add(70);
        val3.add(80);
        val3.add(90);

        Thread thread1 = new Thread(() -> arr.add(values));

        Thread thread2 = new Thread(() -> arr.add(val2));
        Thread thread3 = new Thread(() -> arr.add(val3));

        thread1.start();
        //thread1.join(100);
        thread2.start();
        //thread2.join(100);
        thread3.start();
        //thread3.join(100);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("");
        }
        arr.print();
        

    }

}
