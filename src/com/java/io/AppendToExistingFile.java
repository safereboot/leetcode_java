package com.java.io;

import java.io.FileWriter;
import java.io.IOException;

public class AppendToExistingFile {

	public static void main(String[] args) {
		
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\File01.txt", true);
			fw.write("...appending this");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
