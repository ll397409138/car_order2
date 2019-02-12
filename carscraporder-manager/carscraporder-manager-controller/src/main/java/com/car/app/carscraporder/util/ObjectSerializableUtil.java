package com.car.app.carscraporder.util;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;

public class ObjectSerializableUtil {

	public static void serialization (Object object, String serializationFilePath) { 
		File file = new File(serializationFilePath); 
		if (!new File(file.getParent()).exists()) 
		new File(file.getParent()).mkdirs(); 
		if (file.exists()) 
		file.delete(); 
		ObjectOutputStream oos = null;
		try {
	        oos = new ObjectOutputStream(new FileOutputStream(file));
	        oos.writeObject(object);
	        oos.close();
	    } catch (IOException e) {
	        e.printStackTrace();

	        try {if (oos!=null)oos.close();} catch (IOException e1) {e1.printStackTrace();}
	        file.delete();
	    }
	}

	public static Object deserialization (String serializationFilePath) {
	    File file = new File(serializationFilePath);
	    if (!file.exists())
	        return null;
	    else {

	    }
	    try {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
	        Object object = ois.readObject();
	        ois.close();
	        file.delete();
	        return object;
	    } catch (Exception e) {

	        return null;
	    }
	}

	public static boolean delSerlzFile(String serializationFilePath) {
	    File file = new File(serializationFilePath);
	    if (file.exists())
	        return file.delete();
	    return true;
	}
	
		
}
