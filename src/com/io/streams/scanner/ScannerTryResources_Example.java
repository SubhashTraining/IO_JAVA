package com.io.streams.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



/** 
 * 
 * 	When using scanner remove the finally block as its handled by the sanner itself
 *
 */
public class ScannerTryResources_Example {

	public static void main(String args[]) {
		
		
		try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("csv.txt")))) {
		
		
		scanner.useDelimiter(",");
		while(scanner.hasNext())
		{
			// Here scanner picks the next item and use the delimeter to split			
			int taskID= Integer.parseInt(scanner.next());
			scanner.skip(scanner.delimiter());
			String task = scanner.next();
			System.out.println(taskID+"."+task);	
			
			/*
			String[] nextLine = scanner.nextLine().split(",");
			int ID = Integer.parseInt(nextLine[0]);
			String desc = nextLine[1];
			*/
			
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
