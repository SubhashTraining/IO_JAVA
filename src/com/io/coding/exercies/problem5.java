package com.io.coding.exercies;
//Write a Java program to check if the given pathname is a directory or a file.

import java.io.*;
public class problem5 {
	
	public static void main(String args[]) {
		
		File file= new File(".//bin");
		
		if(file.isDirectory())
			System.out.println(file.getName()+" is a directory");
				
		if(file.isFile())
			System.out.println(file.getName()+" is a file");
		
	}

}
