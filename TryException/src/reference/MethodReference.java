/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;


/**
 *
 * @author Dan
*/
interface Sayable{
	void say();
}
public class MethodReference {
	public static void saySomething(){
		System.out.println("Hello, this is static method.");
        
	}
	public static void main(String[] args) {
	    // Referring static method
             
	    Sayable sayable = MethodReference::saySomething;
	    // Calling interface method
	    sayable.say();
            System.out.println("Classloader of this class:"+MethodReference.class.getClassLoader()); 
	}
}
