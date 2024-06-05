package it.education.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import it.education.util.JdbcUtils;

public class CourseWebDao implements DaoInterface<Course, Integer> {

	@Override
	public Collection<Course> retriveAll() {

		Collection<Course> allCourse = new ArrayList<>();
		String sqlQuery = "select course_id,course_name,course_provider,course_duration, course_fees from course_master";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)) {
			while (rs.next()) {

				int courseId = rs.getInt(1);
				String name = rs.getString(2);
				String provider = rs.getString(3);
				int duration = rs.getInt(4);
				int fees = rs.getInt(5);

				Course currentcorse = new Course(courseId, name, provider, duration, fees);
				allCourse.add(currentcorse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allCourse;

	}

	@Override
	public Course retrieveOne(Integer id) {
		// featching single agent id and returning it
		Course foundCourse = null;
		String sqlQuery = "select course_id,course_name,course_provider,course_duration, course_fees from course_master where course_id=? ";

		try (Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())// customer exist
			{
				int courseId = rs.getInt(1);
				String name = rs.getString(2);
				String provider = rs.getString(3);
				int duration = rs.getInt(4);
				int fees = rs.getInt(5);

				foundCourse = new Course(courseId, name, provider, duration, fees);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundCourse;
	}

	@Override
	public int create(Course courseRef) {
		String sqlQuery = "insert into course_master values(?,?,?,?,?)";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)) {
			// retriving data from customerref
			int courseId = courseRef.getCourseId();
			String name = courseRef.getName();
			String provider = courseRef.getProvider();
			int duration = courseRef.getDuration();
			int fees = courseRef.getFees();

			// seting data in place of unknown parameter
			pstmt.setInt(1, courseId);
			pstmt.setString(2, name);
			pstmt.setString(3, provider);
			pstmt.setInt(4, duration);
			pstmt.setInt(5, fees);

			int updatecount = pstmt.executeUpdate();
			System.out.println(updatecount + "record inserted");
			return updatecount;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}

	@Override
	public void Delete(Integer id) {

		String sqlQuery = "delete from course_master where course_id=?";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)) {
			pstmt.setInt(1, id);
			int updateCount = pstmt.executeUpdate();
			if (updateCount != 0)
				System.out.println(updateCount + "delete record");
			else
				System.out.println("record not found");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void update(Course modifieadCourse) {
		// we can update both or any one
		String sqlQuery = "UPDATE course_master set name,provider,duration,fees where course_id=?";
		int courseId = modifieadCourse.getCourseId();
		String name = modifieadCourse.getName();
		String provider = modifieadCourse.getProvider();
		int duration = modifieadCourse.getDuration();
		int fees = modifieadCourse.getFees();

		try (Connection dbcConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbcConnection.prepareStatement(sqlQuery)) {
			pstmt.setInt(1, courseId);
			pstmt.setString(2, name);
			pstmt.setString(3, provider);
			pstmt.setInt(4, duration);
			pstmt.setInt(5, fees);
			int updatecount = pstmt.executeUpdate();
			System.out.println(updatecount + "record updated");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
