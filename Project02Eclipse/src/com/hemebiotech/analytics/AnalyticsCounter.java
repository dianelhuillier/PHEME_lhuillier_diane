package com.hemebiotech.analytics;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {


	public static void main(String args[]) throws Exception {
		//Input will be generated by ReadSymptomDataFromFile and classed in an TreeMap : for organisation
		TreeMap<String, Integer> results = new TreeMap<String, Integer>();
		ISymptomReader iSymptomReader = new ReadSymptomDataFromFile("symptoms.txt"); 
		List<String>listOfSymptoms = iSymptomReader.getSymptoms();

		//Counter
		try {
			for (int i=0; i<listOfSymptoms.size(); i++) {		
				if (results.containsKey(listOfSymptoms.get(i))) {  //Checking if the String is existing
					int count = 0;
					count = results.get(listOfSymptoms.get(i));
					count++;
					results.put(listOfSymptoms.get(i), count);
				} else {									//If not existing, creating it with count = 1
					results.put(listOfSymptoms.get(i), 1);
				}

			}


		} catch (Exception e) {
			e.printStackTrace();
		}



		// next generate output 
		try(PrintWriter writer = new PrintWriter ("results.out", "UTF-8")){
			for (String symptom : results.keySet()) {
				System.out.println(symptom + " : " + results.get(symptom));	// We print out on terminal
				writer.write(symptom + " : " + results.get(symptom) + "\n");	// We write on a file
			}
			System.out.println("Results written in \"results.out\"");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
