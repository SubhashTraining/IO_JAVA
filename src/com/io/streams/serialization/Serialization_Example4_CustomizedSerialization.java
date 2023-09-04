package com.io.streams.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 
 * During serialization, there may be data loss if we use the ‘transient’ keyword. 
 * ‘Transient’ keyword is used on the variables which we don’t want to serialize. 
 * But sometimes, it is needed to serialize them in a different manner than the default serialization (
 * such as encrypting before serializing etc.), in that case, 
 * we have to use custom serialization and deserialization.
	
	 private void writeObject(ObjectOutputStream oos) throws Exception:
	 This method will be executed automatically by the jvm(also known as Callback Methods) 
	 at the time of serialization. Hence to perform any activity during serialization, 
	 it must be defined only in this method.

	private void readObject(ObjectInputStream ois) throws Exception: 
	This method will be executed automatically by the jvm(also known as Callback Methods) 
	at the time of deserialization. Hence to perform any activity during deserialization, 
	it must be defined only in this method.

 *
 */
public class Serialization_Example4_CustomizedSerialization {

}


class GfgAccount implements Serializable {
	  
    String username = "gfg_admin";
  
    transient String pwd = "geeks";
  
    // Performing customized serialization using the below two methods:
    // this method is executed by jvm when writeObject() on
    // Account object reference in main method is
    // executed by jvm.
    private void writeObject(ObjectOutputStream oos) throws Exception
    {
        // to perform default serialization of Account object.
        oos.defaultWriteObject();
  
        // epwd (encrypted password)
        String epwd = "123" + pwd;
  
        // writing encrypted password to the file
        oos.writeObject(epwd);
    }
  
    // this method is executed by jvm when readObject() on
    // Account object reference in main method is executed by jvm.
    private void readObject(ObjectInputStream ois) throws Exception
    {
        // performing default deserialization of Account object
        ois.defaultReadObject();
  
        // deserializing the encrypted password from the file
        String epwd = (String)ois.readObject();
  
        // decrypting it and saving it to the original password
        // string starting from 3rd  index till the last index
        pwd = epwd.substring(3);
    }
}