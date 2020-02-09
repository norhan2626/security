/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticclassloader;

/**
 *
 * @author Dan
 */
public class TestStatic  {
    public static void main(String[] args) throws Exception {
        
        JiaClassLoader loader1 = new JiaClassLoader();
        JiaClassLoader loader2 = new JiaClassLoader();
        if(loader1.equals(loader2)){
            System.out.println("two classloaders are same");
        }
        else {
            System.out.println("two classloaders are different");
        }

        Class clsA = Class.forName("staticclassloader.AStatic", true, loader1);
        Class clsB = Class.forName("staticclassloader.AStatic", true, loader2);

        System.out.println("staticclassloader.AStatic class: " + clsA);

        Object instanceA = clsA.newInstance();
        Object instanceB = clsB.newInstance();


        if (clsA.equals(clsB)) {
            System.out.println("class loaded in different customer classloader are same");
        }
        else {
            System.out.println("class loaded in different customer classloader are different.");
        }

        clsA.getMethod("setYiyu",int.class).invoke(instanceA, 1);
        clsA.getMethod("printYiyu", String.class).invoke(instanceA, "instanceA");
        clsB.getMethod("printYiyu", String.class).invoke(instanceB, "instanceB");
       
    }
}
