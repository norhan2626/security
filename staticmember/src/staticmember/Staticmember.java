/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticmember;

/**
 *
 * @author Dan
 */
class OuterClass {

    private static String msg = "Welcome";

    // Static nested class 
    public static class NestedStaticClass {

        // Only static members of Outer class is directly accessible in nested  
        // static class  
        public void printMessage() {

            // Try making 'message' a non-static variable, there will be  
            // compiler error   
            System.out.println("Message from nested static class: " + msg);
            System.out.println("Classloader of this class:"+NestedStaticClass.class.getClassLoader()); 
        }
    }

    // non-static nested class - also called Inner class 
    public class InnerClass {

        // Both static and non-static members of Outer class are accessible in  
        // this Inner class 
        public void display() {
            System.out.println("Message from non-static nested class: " + msg);
        }
    }
}

public class Staticmember {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create instance of nested Static class 
        
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();
System.out.println("Classloader of this class:"+Staticmember.class.getClassLoader()); 
        // call non static method of nested static class 
        printer.printMessage();

        // In order to create instance of Inner class we need an Outer class  
        // instance. Let us create Outer class instance for creating  
        // non-static nested class 
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();

        // calling non-static method of Inner class 
        inner.display();

        // we can also combine above steps in one step to create instance of  
        // Inner class 
        OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

        // similarly we can now call Inner class method 
        innerObject.display();
    }
}
