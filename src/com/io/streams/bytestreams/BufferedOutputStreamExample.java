package com.io.streams.bytestreams;

import java.io.*;
public class BufferedOutputStreamExample {
	
	public static void main(String args[]) {
		
		FileOutputStream fos= null;
		BufferedOutputStream  bos = null;
		
		try {
			fos= new FileOutputStream("destination1.txt");
			bos = new BufferedOutputStream(fos);
			
			String str = "I am implementing Buffered Output Stream";
			char[] c = str.toCharArray();
			int i =0;
			
			while(i<str.length()) {
				
				bos.write(c[i++]);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// you need to close bos before closing fos. 
		finally {
			
				try {
					if(bos!=null) {
						bos.close();
					}
					
					if (fos!=null)
						fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
	}

}
