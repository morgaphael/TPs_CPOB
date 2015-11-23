package edu.iut.app;

public class Classroom {
	
	public Classroom() {
		classRoomNumber="not affected";
	}
	
	public Classroom(String classRoomNumber) {
		super();
		this.classRoomNumber = classRoomNumber;
	}

	public void setClassRoomNumber(String classRoomNumber) {
		this.classRoomNumber = classRoomNumber;
	}

	public String getClassRoomNumber() {
		return classRoomNumber;
	}
	
	protected String classRoomNumber;
}
