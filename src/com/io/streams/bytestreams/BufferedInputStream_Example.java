package com.io.streams.bytestreams;
/*
 * Buffered input stream is used to speed up the file read or write opertaions
 * 
 * Buffer input read creates a temporary array and reads many bytes at a time from a file
 * 
 * when the array is empty the buffer is filled from the original input stream
 * 
 * Buffered input stream is a wrapper around fileinputstream
 * 
 */

import java.io.*;
public class BufferedInputStream_Example {
	
	
	public static void main(String args[]) {
		FileInputStream fis  = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream("sources.txt");
			bis= new BufferedInputStream(fis);
			
			
			// (bis.marksupported) returned false so commeneted it
			/*
			
			//Mark method marks a position in the stream, when you read beyoong 
			//this position a rest with point the position back to mark
			if(bis.markSupported()){
				System.out.println("Mark option is not supported");
				System.exit(0);
			}
			*/
			bis.mark(1);
			System.out.println((char)bis.read());// I
			bis.mark(0);
			
			System.out.println((char)bis.read()); //a
			System.out.println((char)bis.read()); //m
			System.out.println((char)bis.read()); // space
			
			bis.reset(); //will again point to a
			
			System.out.println((char)bis.read());
			System.out.println((char)bis.read());
			System.out.println((char)bis.read());
			System.out.println((char)bis.read());
			
			bis.reset();
			int x=0;
			System.out.println();
			while((x=bis.read())!=-1) {
				System.out.print((char)x);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	

}
