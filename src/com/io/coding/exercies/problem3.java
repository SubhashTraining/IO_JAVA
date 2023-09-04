package com.io.coding.exercies;
/// Check if a file or directory specified by pathname exists or not

import java.io.*;
public class problem3 {
	
	public static void main(String args[]) {
		
		
		File file = new File(".\\csv.txt");
		
		if(file.exists()) {
			System.out.println(file.getName()+" exists");
		}
		else
			System.out.println(file.getName()+" does not exists");
		
		
		file = new File(".\\bin");
		if(file.isDirectory()) {
			System.out.println(file.getName()+ " is a directory");
		}
		else {
			System.out.println(file.getName()+" is not a directory");
		}
		
	}

}
