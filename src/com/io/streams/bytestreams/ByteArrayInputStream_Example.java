package com.io.streams.bytestreams;

/*
 * The ByteArrayInputStream is composed of two words: ByteArray and InputStream. 
 * As the name suggests, it can be used to read byte array as input stream. 
 * Java ByteArrayInputStream class contains an internal buffer which is used to read byte array as stream. 
 * In this stream, the data is read from a byte array.
 */

import java.io.*;
import java.util.Arrays;
public class ByteArrayInputStream_Example {

	public static void main(String args[]) throws IOException   {
		
		FileInputStream fis = null;
		String s = "";
		
		int c=0;
		try {
			fis=new FileInputStream("sources.txt");
			
				while((c=fis.read())!=-1){
					s= s+(char) c;
				}			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(fis!=null)
			{
				fis.close();
			}
		}
		
		
		byte[] buf = s.getBytes();
		System.out.println(Arrays.toString(buf));
		//Parameters:buf the input buffer.
		ByteArrayInputStream b = new ByteArrayInputStream(buf);
		
		while((c= b.read())!=-1) {
			
			System.out.println((char)c +":" + c );
			
		}	
		if(b!=null)
			b.close();
		
	}
	
}
