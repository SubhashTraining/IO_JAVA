package com.io.streams.bytestreams;


/*
 * Java ByteArrayOutputStream class is used to write common data into multiple files. 
 * In this stream, the data is written into a byte array which can be written to multiple streams later. 
 * The ByteArrayOutputStream holds a copy of data and forwards it to multiple streams.
 */

import java.io.*;
public class ByteArrayOutputStream_Example {

	
	public static void main(String args[]) {
		
		FileOutputStream fos= null;
		ByteArrayOutputStream bos = null;		
		
		String s = "Byte Array Output Stream";
		
		bos= new ByteArrayOutputStream();
		
		try {
			bos.write(s.getBytes());
			bos.writeTo(fos);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {			
				try {
					if(bos!=null)
					bos.close();
					if(fos !=null)
						fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
}
