package it.education;

import java.util.Collection;

import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.education.entity.Course;

public class RetriveAllCourseMAin {
	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef = new CourseDao();
		Collection<Course> allCourse = daoRef.retriveAll();
		for (Course course : allCourse) {
			System.out.println(course);
		}
	}
}
