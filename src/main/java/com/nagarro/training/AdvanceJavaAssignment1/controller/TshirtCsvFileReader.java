package com.nagarro.training.AdvanceJavaAssignment1.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.nagarro.training.AdvanceJavaAssignment1.model.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class TshirtCsvFileReader  {

	public static HashSet<Tshirt> getAllTshirts() {
		
		HashSet<Tshirt> getAllShirts = new HashSet<Tshirt>();

		try {
			HashSet<File> getalldata = new HashSet<>(
					Set.of(new File("CSV/")
							.listFiles(obj -> obj.isFile() 
									&& obj.getName().endsWith(".csv"))));
			
			
			if(getalldata != null) {
				for(File file : getalldata) {
					CSVParser parser = new CSVParserBuilder()
							.withSeparator('|').withIgnoreQuotations(true)
							.build();
					CSVReader csvReader = new CSVReaderBuilder(new FileReader(file))
							.withCSVParser(parser).withSkipLines(1)
							.build();

					String[] S;   
					try {
						while ((S = csvReader.readNext()) != null) {
							Tshirt tshirt = new Tshirt();

							tshirt.setId(S[0]);
							tshirt.setName(S[1]);
							tshirt.setColor(Color.valueOf(S[2].toUpperCase()));
							tshirt.setGender(Gender.valueOf(S[3].toUpperCase()));
							tshirt.setSize(Size.valueOf(S[4].toUpperCase()));
							tshirt.setPrice(Double.parseDouble(S[5]));
							tshirt.setRating(Double.parseDouble(S[6]));
							tshirt.setAvalibilty(S[7]);

							getAllShirts.add(tshirt);

						}

					} catch (IOException e) {
						e.printStackTrace();
				}
			}

			
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : CSV file not found");
		}
		return getAllShirts;
	}

}
