package com.nagarro.training.AdvanceJavaAssignment1.comparator;

import java.util.Comparator;
import com.nagarro.training.AdvanceJavaAssignment1.model.Tshirt;




public class RatingComparator implements Comparator<Tshirt> {

	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		
		return (int)(tshirt2.getRating()-tshirt1.getRating());
	}
}
