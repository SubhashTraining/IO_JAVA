package com.io.streams.charstreams;
import java.io.*;
import java.util.Arrays;
public class CharacterStreamExample {

   public static void main(String args[]) throws IOException {
     
	   
	  String s = "Subhash";
	  System.out.println(Arrays.toString(s.getBytes()));
	   
	  FileReader in = null;
      FileWriter out = null;

       // Reading source file using read method 
        // and write to file using write method
      try {
    	  
    	  //File not found exception if file is not found
    	  in = new FileReader("sources.txt");
    	  out = new FileWriter("destination.txt");
         
        
         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      }
       finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}
