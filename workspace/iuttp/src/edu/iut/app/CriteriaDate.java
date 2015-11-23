package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;

public class CriteriaDate implements ICriteria {

	@Override
	public ArrayList<ExamEvent> meetCriteria(ArrayList<ExamEvent> l) {
		ArrayList<ExamEvent> matching = new ArrayList<ExamEvent>();
		Date today = new Date();
		Date limit = new Date(1467756000); /* 6 juillet minuit */
		for(ExamEvent e : l){
			if(e.getExamDate().after(today) && e.getExamDate().before(limit))
				matching.add(e);
		}
		return matching;
	}

}
