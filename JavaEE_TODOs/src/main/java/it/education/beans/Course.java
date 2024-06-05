package it.education.beans;

import java.util.Objects;

public class Course {

	int courseId;
	String name;
	String provider;
	int duration;
	int fees;
	
	public Course() {
		
	}
	public Course(int courseId, String name, String provider, int duration, int fees) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.provider = provider;
		this.duration = duration;
		this.fees = fees;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(courseId, duration, fees, name, provider);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return courseId == other.courseId && duration == other.duration && fees == other.fees
				&& Objects.equals(name, other.name) && Objects.equals(provider, other.provider);
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", provider=" + provider + ", duration=" + duration
				+ ", fees=" + fees + "]";
	}
	

}
