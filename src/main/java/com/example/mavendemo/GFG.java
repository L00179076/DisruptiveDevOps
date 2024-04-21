package com.example.mavendemo;
// Java program to Generate MD5 Checksum for Files

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GFG {

	// this method gives a NoSuchAlgorithmException in case
	// we pass a string which doesn't have any hashing
	// algorithm in its correspondence

	public static void main(String[] args)
		throws IOException, NoSuchAlgorithmException
	{

		// create a file object referencing any file from
		// the system of which checksum is to be generated
		File file = new File("D:\\Dissruptive DevOps\\Code AWS Bracket.txt");

		// instantiate a MessageDigest Object by passing
		// string "MD5" this means that this object will use
		// MD5 hashing algorithm to generate the checksum
		MessageDigest mdigest = MessageDigest.getInstance("MD5");

		// Get the checksum
		String checksum = checksum(mdigest, file);

		// print out the checksum
		System.out.println(checksum);
	}

	// this method return the complete hash of the file
	// passed
	private static String checksum(MessageDigest digest,
								File file)
		throws IOException
	{
		// Get file input stream for reading the file
		// content
		FileInputStream fis = new FileInputStream(file);

		// Create byte array to read data in chunks
		byte[] byteArray = new byte[1024];
		int bytesCount = 0;

		// read the data from file and update that data in
		// the message digest
		while ((bytesCount = fis.read(byteArray)) != -1)
		{
			digest.update(byteArray, 0, bytesCount);
		};

		// close the input stream
		fis.close();

		// store the bytes returned by the digest() method
		byte[] bytes = digest.digest();

		// this array of bytes has bytes in decimal format
		// so we need to convert it into hexadecimal format

		// for this we create an object of StringBuilder
		// since it allows us to update the string i.e. its
		// mutable
		StringBuilder sb = new StringBuilder();
	
		// loop through the bytes array
		for (int i = 0; i < bytes.length; i++) {
		
			// the following line converts the decimal into
			// hexadecimal format and appends that to the
			// StringBuilder object
			sb.append(Integer
					.toString((bytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		// finally we return the complete hash
		return sb.toString();
	}
}
