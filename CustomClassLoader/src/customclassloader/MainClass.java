/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customclassloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Dan
 */
public class MainClass {
       public static void main(String[] args) throws InstantiationException, IllegalAccessException,
                 NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

	      CustomClassLoader loader = new CustomClassLoader();
              Class<?> c = loader.findClass("customclassloader.Test");
         
              Object ob = c.newInstance();
              Method md = c.getMethod("show");
              md.invoke(ob);
       }
}