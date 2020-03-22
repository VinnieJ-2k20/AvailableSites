package com.gmail.ptimofejev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		File sites = new File ("sites.txt");
		String[] address = readFileToString(sites).split(System.lineSeparator());
		
		try { 
			for (String site : address) {
				System.out.println(site + " : " + checkAvailability(site));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static String readFileToString(File input) {
		StringBuilder sb1 = new StringBuilder();
		String nextline = null;
		try (BufferedReader br1 = new BufferedReader(new FileReader(input))) {
			while ((nextline = br1.readLine()) != null) {
				sb1.append(nextline);
				sb1.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb1.toString();
	}
	
	public static boolean checkAvailability(String host) throws IOException {
		Map<String, List<String>> headers = WebService.getHeadersFromURL(host);
		List <String> response = headers.get(null);
		if (response == null) {
			return false;
		}
		for (String code : response) {
			
			if (code.indexOf("200") >= 0) {
				return true;
			}
		}
		return false;
	}
}
