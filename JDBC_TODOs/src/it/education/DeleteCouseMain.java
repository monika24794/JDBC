package it.education;

import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.education.entity.Course;

public class DeleteCouseMain {
public static void main(String[] args) {
	DaoInterface<Course, Integer> daoRef=new CourseDao();
	daoRef.Delete(5);
}
}
