package com.io.streams.charstreams;

import java.io.*;

/*
 *  reader.write - writes character 
 *  reader.read - reads one character at a time
 */

public class BufferedReaderWriter_Example {
	
	public static void main(String args[])
	{
		
		
		FileReader reader  = null;
		BufferedReader bReader= null;
		
		FileWriter writer = null;
		BufferedWriter bWriter = null;
		
		try {
			// if this is a directory "sources.txt" - create a directory with name "sources.txt" will throw an
			// exception "sources.txt" (is a directory)
			reader = new FileReader("sources.txt");
			writer = new FileWriter("destination.txt");
			
			bReader = new BufferedReader(reader);
			bWriter = new BufferedWriter(writer);
			
			String line="";
					
			while((line= bReader.readLine())!=null) {
				
				bWriter.write(line);	
				bWriter.write("\n");
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		
			try {
				if(bReader!=null)
					bReader.close();
				
				if(bWriter!=null)
					bWriter.close();
				if(reader!=null)
					reader.close();
				
				if(writer!=null)
					writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
