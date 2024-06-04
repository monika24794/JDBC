package it.education;

import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.education.entity.Course;

public class UpdateCourseMAin {
	public static void main(String[] args) {
	DaoInterface<Course, Integer> daoRef=new CourseDao();
	
	Course courseRef =daoRef.retrieveOne(5);
	courseRef.setName("WEBModule");
	courseRef.setProvider("Cdac");
	courseRef.setDuration(100);
	courseRef.setFees(100000);
	daoRef.update(courseRef);

	
	}
}
