package com.io.streams.serialization;


import java.io.*;



public class Serialization_Example3 {
	 
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Serial d1=new  Serial();
	     //Serialization started
	     System.out.println("serialization started");
	     FileOutputStream fos= new FileOutputStream("abc.ser");
	     ObjectOutputStream oos=new ObjectOutputStream(fos);
	     oos.writeObject(d1);
	     System.out.println("Serialization ended");
	  
	     //Deserialization started
	     System.out.println("Deserialization started");
	     FileInputStream fis=new FileInputStream("abc.ser");
	     ObjectInputStream ois=new ObjectInputStream(fis);
	     Serial d2=(Serial) ois.readObject();
	     System.out.println("Deserialization ended");
	     System.out.println("Dog object data");
	     //final result
	     System.out.println(d2.i+"\t" +d2.x);
	}
}


class Serial{
	
	int i=10;
	final transient int x = 30;
}