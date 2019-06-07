package com.harsh.custom_class_loader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * To create a custom class loader, we have to extend java.lang.ClassLoader class and
 * implement some of it's crucial methods, like loadClass(String name).
 * This method is called every time a Class needs to be loaded in JVM.
 * 
 * 
 * @author harshul.varshney
 *
 */
public class MyClassLoader extends ClassLoader {
	
	/**
	 * Parent ClassLoader passed to this constructor
     * will be used if this ClassLoader can not resolve a
     * particular class.
     * 
	 * @param parent
	 */
	public MyClassLoader(ClassLoader parent) {
		super(parent);
	}
	
	/**
	 * Loads a given class from .class file just like the default ClassLoader. This method could be
     * changed to load the class over network from some other server or from the database.
     * 
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 */
	private Class<?> getClass(String name) throws ClassNotFoundException {
		
		String file = name.replace('.', File.separatorChar) + ".class";
		byte[] b = null;
        try {
            // This loads the byte code data from the file
            b = loadClassData(file);
            // defineClass is inherited from the ClassLoader class
            // and converts the byte array into a Class
            Class<?> c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	@Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("loading class '" + name + "'");
        if (name.startsWith("com.harsh.")) {
            return getClass(name);
        }
        return super.loadClass(name);
    }
	
	/**
	 * Loads a given file (presumably .class) into a byte array.
     * The file should be accessible as a resource, for example it could be located on the classpath.
     * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	private byte[] loadClassData(String name) throws IOException {
		InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
		int size = stream.available();
		byte buff[] = new byte[size];
		DataInputStream in = new DataInputStream(stream);
		// Reading the binary data
		in.readFully(buff);
		in.close();
		return buff;
	}

}
