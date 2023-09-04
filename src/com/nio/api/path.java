package com.nio.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.stream.Stream;


/*
 * https://www.marcobehler.com/guides/java-files#_writing_reading_files
 */

public class path {
	
	public static void main(String args[]) throws URISyntaxException, IOException {
		
		
		
		/*
		 *	 It does not matter if you are using forward slashes 
		 *	e.g. on Windows, as the Path API is smart enough to construct the right path, 
		 *	independently of the OS and any forward-backward slash issues.
		 */
		Path path = Path.of(".\\bin");
		
		Path path1 = Path.of("./bin");
		
		System.out.println(path.getFileName());
		
		System.out.println(path1.getFileName());
				
			
		path = Path.of("c:" , "dev", "licenses", "windows", "readme.txt");
		System.out.println(path);
		/*
		 * Instead, you can pass a sequence of strings to the Path.of method, 
		 * or construct the parent directory and use it to get a child file (.resolve(child)).
		 */
		path = Path.of("D:","programfiles").resolve("delta.file");
		System.out.println(path);
		
		//you can also pass URIs into the Path.of call.
		path = Path.of(new URI("file:///c:/dev/licenses/windows/readme.txt"));
		System.out.println(path);
		
		/*	Constructing a path object or resolving a child, does not mean the file or directory actually exists. 
		 * 	The path is merely a reference to a potential file. So, you’ll have to separately verify its existenc
		 * 
		 */
		
		path = Path.of(".\\").resolve("csv.txt");
		System.out.println(Files.exists(path));
		
		System.out.println(Files.isDirectory(path));
		
	
		
		if(path == null || !Files.exists(path))
			System.out.println(path+ " Path or File does not exist");
		
		else
			System.out.println(path + " exists");
		
		try {
			System.out.println(Files.getLastModifiedTime(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(Files.getOwner(path));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * When creating temp files, you can specify a prefix (first param) and a suffix (second param). 
		 * Both can be null. The prefix will be prefixed (duh!) to the temp file name, 
		 * the suffix is essentially the file extension, 
		 * and if you leave it out a default extension of ".tmp" will be used.
		 * The file will be created in the default temporary-file directory.
		 */
		
		Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
		System.out.println("tempFile1 = " + tempFile1);
		
		
		Path tempFile2 = Files.createTempFile(path.getParent(), "somePrefixOrNull", ".jpg");
		System.out.println("tempFile2 = " + tempFile2);
		
		//The file will be created in the default temporary-file directory.
		Path tmpDirectory = Files.createTempDirectory("prefix");
		System.out.println("tmpDirectory = " + tmpDirectory);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//How to create files and directories
		
		
		Path newDirectory = Files.createDirectories(path.getParent().resolve("some/new/dir"));
		System.out.println("newDirectory = " + newDirectory);

		Path newFile = Files.createFile(newDirectory.resolve("emptyFile.txt"));
		System.out.println("newFile = " + newFile);
		
		
		
		//How to write strings to files
		Path utfFile = Files.createTempFile("some", ".txt");
		Files.writeString(utfFile, "this is my string ää öö üü"); // UTF 8
		System.out.println("utfFile = " + utfFile);

		Path iso88591File = Files.createTempFile("some", ".txt");
		Files.writeString(iso88591File, "this is my string ää öö üü", StandardCharsets.ISO_8859_1); // otherwise == utf8
		System.out.println("iso88591File = " + iso88591File);

		
		
		Path anotherIso88591File = Files.createTempFile("some", ".txt");
		Files.write(anotherIso88591File, "this is my string ää öö üü".getBytes(StandardCharsets.ISO_8859_1));
		System.out.println("anotherIso88591File = " + anotherIso88591File);
		
		
		//Using Writers and OutputStreams
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(utfFile)) {
		    // handle reader
		}

		try (OutputStream os = Files.newOutputStream(utfFile)) {
		    // handle outputstream
		}
		
		//How to read strings from files
		String s = Files.readString(utfFile);// UTF 8
		System.out.println("s = " + s);

		s = Files.readString(utfFile, StandardCharsets.ISO_8859_1); // otherwise == utf8
		System.out.println("s = " + s);
		
		
		//How to read bytes from files
		
		s = new String(Files.readAllBytes(utfFile), StandardCharsets.UTF_8);
		System.out.println("s = " + s);
		
		
		//Using Readers and InputStreams
		try (BufferedReader bufferedReader = Files.newBufferedReader(utfFile)) {
		    // handle reader
		}

		try (InputStream is = Files.newInputStream(utfFile)) {
		    // handle inputstream
		}
		
		
		
		//How to move files
		
		// The below is wrong
		Path utfFile1 = Files.createTempFile("some", ".txt");

		try {
		    Files.move(utfFile1, Path.of("c:\\dev"));  // this is wrong!
		} catch (FileAlreadyExistsException e) {
		    // welp, that din't work!
		}
		
		/*
		 * There is a Files.move method, but it does not move a file to a designated directory (which you might expect).

			test.jpg → c:\temp does not work.

			test.jpg → c:\temp\test.jpg works.
		 */
		
		
		Files.move(utfFile, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()));
		//So, you don’t move files to folders, but you "move" them to their full new path, including the filename and extension.
		
		
		//File Move Options
		/*	When moving files, you can also specify how you want to move to happen, depending on the capabilities of the underlying file system.

			By default, if the target file already exists, a FileAlreadyExistsException will be thrown.

			If you specify the StandardCopyOption.REPLACE_EXISTING option, the target file will be overwritten.

			If you specify the StandardCopyOption.ATOMIC_MOVE option, you can move a file into a directory and be guaranteed 
			that any process watching the directory accesses a complete file and not just a partial file.
		 */
		
		
		Path utfFile2 = Files.createTempFile("some", ".txt");
		Files.move(utfFile2, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);

		Path utfFile3 = Files.createTempFile("some", ".txt");
		Files.move(utfFile3, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.ATOMIC_MOVE);
		
	
		
		//How to delete files
		try {
		    Files.delete(utfFile2);
		} catch (DirectoryNotEmptyException e) {
		    e.printStackTrace();
		}
		
		/*
		 * There is the Files.delete method, which allows you to delete files and directories, 
		 * but directories only if they are empty.
		 */
		
		
		
		//How to delete non-empty directories
		
		/*
		 * Files.walk will walk a file tree depth-first, starting with the directory you specify. 
		 * The reverseOrder comparator will make sure that you delete all children, before deleting the actual directory.

		 * Unfortunately, you’ll also need to catch the IOException, 
		 * when using Files.delete inside the forEach consumer. 
		 * A whole lot of code for deleting a non-empty directory, isn’t it?
		 */
		
		try (Stream<Path> walk = Files.walk(utfFile2)) {
		    walk.sorted(Comparator.reverseOrder()).forEach(file -> {
		        try {
		            Files.delete(file);
		        } catch (IOException e) {
		            // something could not be deleted..
		            e.printStackTrace();
		        }
		    });
		}

		
		
			
		//How to list files in the same directory
		
		
		
		
		
	}

}
