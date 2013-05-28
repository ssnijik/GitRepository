package com.tutoring.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class StaticUtil {
	private static final int BUFFER_SIZE=16*1024;
	public static String generateRandomString(int length){
		final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++)
		{
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString();
	}
	public static void copy(File src, File dst) {
        try {
            InputStream in = null ;
            OutputStream out = null ;
             try {
            	 in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
            	 out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                 byte [] buffer = new byte [BUFFER_SIZE];
                 while (in.read(buffer) > 0 ) {
                	 out.write(buffer);
                 } 
            } finally {
                 if ( null != in) {
                	 in.close();
                 } 
                 if ( null != out) {
                	 out.close();
                 } 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	
	public static void copy(InputStream in, File dst) {
        try {
            OutputStream out = null ;
             try {
            	 //in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
            	 out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                 byte [] buffer = new byte [BUFFER_SIZE];
                 while (in.read(buffer) > 0 ) {
                	 out.write(buffer);
                 } 
            } finally {
                 if ( null != in) {
                	 in.close();
                 } 
                 if ( null != out) {
                	 out.close();
                 } 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
