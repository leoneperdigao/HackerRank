package br.com.leoneperdigao.countingvalleys.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
	
	public static int getEntrySize(String dir) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(dir));
		String n = br.readLine();
		br.close();
        return Integer.valueOf(n);
	}
	
	public static String getPath(String dir) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(dir));
		br.readLine();//jump first line
		String path = br.readLine();
		br.close();
        return path;
	}
	
	private FileUtils() {
		
	}

}
