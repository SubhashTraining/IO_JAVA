package com.io.streams.datainputstreams;



/**
 * 
 * DataInputStream in Java is a filter input stream that provides methods for reading Java’s standard data types.

	It enables you conveniently to read strings and all primitive data types such as int, float, long, double, etc from a stream.

	Java DataInputStream reads bytes from an underlying stream and converts them into suitable primitive-type values or strings.

	It reads them to its underlying byte stream and encodes these values in a machine-independent way.

	The basic input stream provides read methods only for reading bytes or characters. If we want to read the primitive data types, we need to use a filter class DataInputStream.

	DataInputStream class works as wrappers on the existing input stream to filter data in the original stream.
 *
 */


// Input streams throw EOFException on reaching End of file .

// Data Input Stream is a wrapper class for FileInputStream and BufferedInputStream

import java.io.*;
public class DataInputStreams_Example {
	
	public static void main(String args[]) {
		
		try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
			
			boolean eof= true;
			while(eof) {
				try {
				int locId = dis.readInt();
				String desc = dis.readUTF();
				int noOfExits = dis.readInt();
				
				System.out.println(locId+"-"+desc);
				for(int i=0;i<noOfExits;i++) {
					System.out.println("Exit:"+i+"-"+dis.readInt());
				}
				}catch(EOFException e) {
				eof=false;
				}		
			}
		}catch(IOException e) {
			e.printStackTrace();
			}	
		}
	
	
	/**
	 * for (int i = 0; i < prices.length; i ++) {
    	dos.writeDouble(prices[i]);
    	dos.writeChar('\t');
    	dos.writeInt(units[i]);
    	dos.writeChar('\t');
    	dos.writeChars(descs[i]);
    	dos.writeChar('\n');
}
	 */
	}

