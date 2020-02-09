/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticclassloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Dan
 */
public class JiaClassLoader extends ClassLoader {

    /**
     * Parent ClassLoader passed to this constructor
     * will be used if this ClassLoader can not resolve a
     * particular class.
     *
     * @param parent Parent ClassLoader
     *              (may be from getClass().getClassLoader())
     */
    public JiaClassLoader() {
        super(JiaClassLoader.class.getClassLoader());
    }

  
    private synchronized  Class getClass(String name)
        throws ClassNotFoundException {

        Class cls = findLoadedClass(name);
        if (cls != null) {
            System.out.println("class " + name + "has been loaded.");
            return cls;
        } else {
            System.out.println("class " + name + " has not been loaded. Loading now.");
        }


       
        String file = name.replace('.', File.separatorChar)
            + ".class";
        byte[] b = null;
        try {
            // This loads the byte code data from the file
            b = loadClassData(file);
            // defineClass is inherited from the ClassLoader class
            // and converts the byte array into a Class
            cls = defineClass(name, b, 0, b.length);
            resolveClass(cls);
            return cls;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

   
    @Override
    public Class loadClass(String name)
        throws ClassNotFoundException {
        System.out.println("loading class '" + name + "'");
        if (name.startsWith("jia.")) {
            return getClass(name);
        }
        return super.loadClass(name);
    }

   
    private byte[] loadClassData(String name) throws IOException {
        // Opening the file
        InputStream stream = getClass().getClassLoader()
            .getResourceAsStream(name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        // Reading the binary data
        in.readFully(buff);
        in.close();
        return buff;
    }
}
