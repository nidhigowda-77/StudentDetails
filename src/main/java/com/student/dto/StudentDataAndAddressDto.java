package com.student.dto;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StudentDataAndAddressDto {

	@JsonProperty("name")
	@NotBlank
	private String name;

	@Id
	@JsonProperty("rollNo")
	@NotBlank
	private Integer rollNo;

	@JsonProperty("branch")
	@NotBlank
	private String branch;

	@JsonProperty("course")
	@NotBlank
	private String course;
	
	@JsonProperty("year")
	@NotBlank
	private Integer year;
	
	@JsonProperty("state")
	@NotBlank
	private String state;

	@JsonProperty("place")
	@NotBlank
	private String place;

	@Override
	public String toString() {
		return "StudentDataAndAddressDto [name=" + name + ", rollNo=" + rollNo + ", branch=" + branch + ", state="
				+ state + ", place=" + place + ", course=" + course + ", year=" + year + "]";
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branch, course, name, place, rollNo, state, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDataAndAddressDto other = (StudentDataAndAddressDto) obj;
		return Objects.equals(branch, other.branch) && Objects.equals(course, other.course)
				&& Objects.equals(name, other.name) && Objects.equals(place, other.place)
				&& Objects.equals(rollNo, other.rollNo) && Objects.equals(state, other.state)
				&& Objects.equals(year, other.year);
	}
	


}
