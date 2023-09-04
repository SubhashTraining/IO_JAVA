package com.io.streams.scanner;

import java.io.*;
import java.util.Scanner;


/**
 * 
 * 	Sanner if from the util class
 * 	Here the new BufferedReader and File Reader are not closed.
 * 	Scanner close method closes all the streams which implements the 
 * 	closable interface and are created by the scanner
 * 
 *  Buffered Reader and FileReader extends Reader and Reader implements closable interface
 *  So sacnner.close() will inturn close all the streams that implements the closable interface
 *
 */

public class Scanner_Example {
	
	public static void main(String args[]) {
		
		Scanner scanner = null;
		try {
		scanner = new Scanner(new BufferedReader(new FileReader("csv.txt")));
		
		scanner.useDelimiter(",");
		while(scanner.hasNext())
		{
			// Here scanner picks the next item and use the delimeter to split			
			String taskID= scanner.next();
			scanner.skip(scanner.delimiter());
			String task = scanner.next();
			System.out.println(taskID+"."+task);	
			
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {	
				if(scanner!=null)
					scanner.close();	
		}
	}
}
