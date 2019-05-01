package br.com.leoneperdigao.sockmerchant.utils;

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
	
	public static int[] getArray(int n, String dir) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(dir));
		int[] arr = new int[n]; 
		br.readLine();//jump first line
		String[] strArr = br.readLine().split(" ");
		for (int j = 0; j < strArr.length; j++) {
			arr[j] = Integer.valueOf(strArr[j]);
		}
		
		br.close();
        return arr;
	}
	
	private FileUtils() {
		
	}

}
