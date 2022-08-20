package com.nagarro.training.AdvanceJavaAssignment1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.nagarro.training.AdvanceJavaAssignment1.controller.ModificationWatcher;
import com.nagarro.training.AdvanceJavaAssignment1.model.Tshirt;
import com.nagarro.training.AdvanceJavaAssignment1.utility.TshirtSearchIp;
import com.nagarro.training.AdvanceJavaAssignment1.utility.TshirtSearchOp;

import com.nagarro.training.AdvanceJavaAssignment1.views.*;

class Track implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ModificationWatcher.modificationTrack();
	}
	
}

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		String another = "N";
		Scanner sc = new Scanner(System.in);
		
		Track obj1 = new Track();
		Thread t = new Thread(obj1);
		t.start();

		do {
			
			Input input = new Input();
			TshirtSearchIp tshirtSearchIp = input.getInput();

			TshirtSearchOp tshirtSearchOp = new TshirtSearchOp();
			ArrayList<Tshirt> matchedTShirts = tshirtSearchOp.getMatchingTshirts(tshirtSearchIp);

			Output output = new Output();
			output.displayOutput(matchedTShirts);

			System.out.println("Search again ? y/n");
			another = sc.nextLine();
			
		} while (another.equalsIgnoreCase("y"));
		
		sc.close();
		System.out.println("----------Closed--------");
	}
}
