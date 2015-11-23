package edu.iut.app;

import java.util.ArrayList;

public class CriteriaClassroom implements ICriteria {
	@Override
	public ArrayList<ExamEvent> meetCriteria(ArrayList<ExamEvent> l) {
		ArrayList<ExamEvent> matching = new ArrayList<ExamEvent>();
		for(ExamEvent e : l){
			String classroom = e.getClassroom().getClassRoomNumber().toUpperCase();
			if(classroom.matches("[A-Z][0-9]{3}"))
				matching.add(e);
		}
		return matching;
	}

}
