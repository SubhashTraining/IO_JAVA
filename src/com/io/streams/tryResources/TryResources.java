package com.io.streams.tryResources;


/**
 * 	With Byte Streams you can write a 1 byte at a time or byte[]
 * 	for a line break write '/n'
 * 	Try resources automatically close all streams upon exiting the try block
 * 	keeps the code more clean
 */

import java.io.*;
public class TryResources {

	
	public static void main(String args[]) 
	{
		
		try(FileInputStream fis = new FileInputStream("sources.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream("destination.txt")		) 
				{
			
				byte[] byteArray = "Check ByteArray".getBytes();
				int c= -1;
				while((c=bis.read())!=-1) {
					
					fos.write(c);
					
				}
				 
				fos.write('\n');
				fos.write(byteArray);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
