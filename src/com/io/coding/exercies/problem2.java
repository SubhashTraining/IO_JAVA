package com.io.coding.exercies;


//Write a Java program to get specific files with extensions from a specified folder.

import java.io.*;
public class problem2 {

	 
	public static void main(String args[]) {
		
		
		File file = new File(".\\");
		
		String[] files = file.list(new FilenameFilter(
				) {

					@Override
					public boolean accept(File dir, String name) {
						// TODO Auto-generated method stub
						if(name.endsWith(".txt"))
							return true;
						else
							return false;
					}
			
			
		});
		
		for(String f:files) {
			System.out.println(f);
		}
		
	}
	
}
