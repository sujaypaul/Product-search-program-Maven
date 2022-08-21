package com.nagarro.training.AdvanceJavaAssignment1.model;

import java.util.HashSet;

import com.nagarro.training.AdvanceJavaAssignment1.controller.TshirtCsvFileReader;

public class Data {
	public static HashSet<Tshirt> allTshirtData;

	public static void fetchData() {
		allTshirtData = TshirtCsvFileReader.getAllTshirts();
	}
}
