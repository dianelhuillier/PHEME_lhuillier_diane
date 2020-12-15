package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Simple brute force implementation

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() { 
		ArrayList<String> result = new ArrayList<String>();
		//Read every line 
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				//Create new symptom
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public void list(String list) {
		// TODO Auto-generated method stub
		
	}

}
