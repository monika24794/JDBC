package it.education.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import it.education.beans.Course;
import it.education.beans.CourseWebDao;

/**
 * Servlet implementation class CreateCourseServlet
 */
@WebServlet(urlPatterns ={"/createNewCourse"},
name="myCreateCourseServlet")
public class CreateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String id=request.getParameter("Course_id");
		int Course_id=(Integer.parseInt(request.getParameter("course_id")));
		String course_name=request.getParameter("course_name");
		String course_provider=request.getParameter("course_provider");
		//String course_dur=request.getParameter("course_duration");
		int course_duration=Integer.parseInt(request.getParameter("course_duration"));
		//String course_f=request.getParameter("course_fees");
		int course_fees=Integer.parseInt(request.getParameter("course_fees"));
		System.out.println(Course_id+""+course_name+""+course_provider+""+course_duration+""+course_fees);
		Course currentcourse=new Course(Course_id,course_name,course_provider,course_duration , course_fees);
		CourseWebDao courseWebDaoobj=new CourseWebDao();
		int count =courseWebDaoobj.create(currentcourse);
		System.out.println(currentcourse);
			response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String responceText="<h1 style= 'color:red'> Sorry, failed to add record </h1>";
		if(count!=0)
		 responceText="<h1 style= 'color:green'> congratulations, you add record </h1>";
		out.print(responceText);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
