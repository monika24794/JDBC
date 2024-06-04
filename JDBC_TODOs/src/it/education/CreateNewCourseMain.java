package it.education;

import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.education.entity.Course;

public class CreateNewCourseMain {
	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef=new CourseDao();
		Course courseRef=new Course(7, "WEB", "Cdac", 450, 10000);
		daoRef.create(courseRef);
	}

}
