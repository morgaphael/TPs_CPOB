package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;

public class CriteriaPerson implements ICriteria {

	@Override
	public ArrayList<ExamEvent> meetCriteria(ArrayList<ExamEvent> l) {
		ArrayList<ExamEvent> matching = new ArrayList<ExamEvent>();
		for(ExamEvent e : l){
			matching.add(e);
		}
		return matching;
	}

}
