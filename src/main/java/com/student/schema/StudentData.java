package com.student.schema;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentData")
public class StudentData {
	
	private String name;

	@Id
	private Integer rollNo;
	
	private String course;
	
	private String branch;
	
	private Integer year;

	@Override
	public int hashCode() {
		return Objects.hash(branch, course, name, rollNo, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentData other = (StudentData) obj;
		return Objects.equals(branch, other.branch) && Objects.equals(course, other.course)
				&& Objects.equals(name, other.name) && Objects.equals(rollNo, other.rollNo)
				&& Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return "StudentData [name=" + name + ", rollNo=" + rollNo + ", course=" + course + ", branch=" + branch
				+ ", year=" + year + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	
	
}
