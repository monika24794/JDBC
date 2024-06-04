package it.education;

import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.education.entity.Course;

public class RetriveOneCourseMain {
public static void main(String[] args) {
DaoInterface<Course, Integer> daoRef=new CourseDao();
Course courseRef=daoRef.retrieveOne(2);
if(courseRef !=null)
	System.out.println(courseRef);
else
	System.out.println("Course with given id is not aveliable");
}
}
