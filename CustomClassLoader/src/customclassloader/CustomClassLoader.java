/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customclassloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Dan
 */
public class CustomClassLoader extends ClassLoader {
        @Override
      public Class<?> findClass(String name) {
         byte[] bt = loadClassData(name);
         return defineClass(name, bt, 0, bt.length);
      }
      private byte[] loadClassData(String className) {
        //read class
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        //write into byte
        int len =0;
        try {
                     while((len=is.read())!=-1){
                           byteSt.write(len);
                      }
               } catch (IOException e) {
                     e.printStackTrace();
               }
        //convert into byte array
        return byteSt.toByteArray();
     }
    
}
