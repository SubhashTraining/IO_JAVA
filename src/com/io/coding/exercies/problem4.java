package com.io.coding.exercies;


///Write a Java program to check if a file or directory has read and write permissions.

import java.io.*;
public class problem4 {

	public static void main(String args[]) {
		
		File bin = new File(".\\bin");
		File txt = new File(".\\csv.txt");
		
		
		if(bin.canWrite())
			System.out.println(bin.getName()+" has write permission");
		else
			System.out.println(bin.getName()+" has no write permission");
		
		
		if(bin.canRead())
			System.out.println(bin.getName()+ " has read permission");
	}
	
}
