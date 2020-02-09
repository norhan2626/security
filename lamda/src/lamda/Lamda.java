/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamda;

import java.util.function.Predicate;

/**
 *
 * @author Dan
 */
public class Lamda {

    public static String betterString(String[] s1, Predicate<String[]> w) {
        if (w.test(s1)) {
            return s1[0];
        } else {
            return s1[1];
        }

    }

    public static void main(String[] args) {

        String arr[] = {"nour", "fadel"};
        Predicate<String[]> word = (arrayy) -> (arrayy[0].length() > arrayy[1].length());

        System.out.println(betterString(arr, word));
     System.out.println("Classloader of this class:"+Lamda.class.getClassLoader()); 
    }
}
