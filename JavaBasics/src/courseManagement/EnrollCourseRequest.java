package courseManagement;

import userManagement.Student;

//Small helper Class Containing A Student and a Course that they want to enroll
public class EnrollCourseRequest {
	
	private Student student;
	private Course course;
	
	public EnrollCourseRequest(Student student, Course course) {
		this.student = student;
		this.course = course;
	}
	
	//Getters and Setters

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
