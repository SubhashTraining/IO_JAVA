package com.io.streams.bytestreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {
	
    public static void main(String[] args) throws IOException
    {
        FileInputStream sourceStream = null;
        FileOutputStream targetStream = null;
  
        try 
        {
        	
        	// File Input Stream does not create the file
        	// throws FileNotFoundException
        	sourceStream = new FileInputStream("sources.txt");
        	
        	//File output Stream creates the file destination.txt .
        	 
            targetStream = new FileOutputStream ("destination.txt");
           
            // Reading source file using read method 
            // and write to file byte by byte using write method
            int temp;
            
            // read() method returns the next byte of data and if its end of the file returns -1
            while ((temp = sourceStream.read()) != -1)
                targetStream.write((byte)temp);            
        }
        
        // the best practice here is to close the file system in the finally block
        // also check if the stream is not null and close it.
        // bcos of there is an exception while creating the Input Stream here. FileNotFoundException the 
        // entire program stops and the streams will still be null. Its defensive to have this followed
        finally 
        {
            if (sourceStream != null){
                sourceStream.close();   
            }
            if (targetStream != null){           
                targetStream.close(); 
            }
        }
    }
}

