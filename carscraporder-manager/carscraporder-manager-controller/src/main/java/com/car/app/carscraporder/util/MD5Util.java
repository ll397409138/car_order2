package com.car.app.carscraporder.util;

import java.io.InputStream; 
import java.math.BigInteger; 
import java.security.MessageDigest;

import org.springframework.web.multipart.MultipartFile;

public class MD5Util {
	public static String getFileMD5(MultipartFile file) { 
		/* if (!file.exists() || !file.isFile()) { 
		return null; 
		} */ 
		MessageDigest digest = null; 
		InputStream in = null; 
		byte buffer[] = new byte[1024]; 
		int len; 
		try { 
		digest = MessageDigest.getInstance("MD5"); 
		//in = new FileInputStream(file); 
		in=file.getInputStream(); 
		while ((len = in.read(buffer, 0, 1024)) != -1) { 
		digest.update(buffer, 0, len); 
		} 
		in.close(); 
		} catch (Exception e) { 
		e.printStackTrace(); 
		return null; 
		} 
		BigInteger bigInt = new BigInteger(1, digest.digest()); 
		return bigInt.toString(16); 
		}
		
}
