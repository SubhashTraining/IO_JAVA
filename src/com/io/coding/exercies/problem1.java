package com.io.coding.exercies;

/*
 * Get a list of all file/directory names
 */

import java.io.*;
public class problem1 {

	public static void main(String args[]) {
		
		File file = new File("\\");
		System.out.println(file.getAbsolutePath());
		//    C:\
		
		
		
		//. refers to the current directory. Prints all file names in the directory
		file = new File(".");
		System.out.println(file.getAbsolutePath());
		//   C:\Users\subhperu\Documents\Spring\Workspace\IO_JAVA\.
		
		
		file  = new File(".\\src");
		
		String[] files = file.list();
		for(String f: files) {
			System.out.println(f);
		}
				
	}
	
}
