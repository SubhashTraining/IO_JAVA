package com.io.streams.bytestreams;

import java.io.*;
public class FileOutputStream_Example {
	
	public static void main(String argsp[]) throws IOException  {
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("destination.txt");
			//String to char - getBytes()
			byte[] buff = "I am learning java".getBytes();		
			
			
			fos.write(buff);
			if(fos!=null)
				fos.close();
			
			fos= new FileOutputStream("destination2.txt");
			String s= "I am learning java and trying charArray";
			// String to char[]
			char[] c = s.toCharArray();
			
			int i =0;
			while(i<c.length) {
				//char is auto converted to into and written 
				fos.write(c[i++]);
			}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fos!=null)
				fos.close();
		}
		
		
	}

}
