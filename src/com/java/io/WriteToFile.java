package com.java.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {

		File f = new File("File01.txt");
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("xagjdgjkashd");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
