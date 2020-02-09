/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpression;



/**
 *
 * @author Dan
 */
public class LambdaExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      FuncInterface fobj = (int x) -> System.out.println(2 * x); 
  System.out.println("Classloader of this class:"+FuncInterface.class.getClassLoader());
  System.out.println("Classloader of this class:"+fobj.getClass().getClassLoader());
        // This calls above lambda expression and prints 10. 
        fobj.abstractFun(5); 
    }
    
}
interface FuncInterface { 
    // An abstract function 
    void abstractFun(int x); 
  
// A non-abstract (or default) function 
default void
    normalFun() 
    { 
        System.out.println("Hello"); 
    } 
} 
