package com.student.dto;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StudentDataAndAddressDto {

	@Id
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("rollNo")
	private Integer rollNo;

	@JsonProperty("branch")
	private String branch;

	@JsonProperty("state")
	private String state;

	@JsonProperty("place")
	private String place;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(branch, id, name, place, rollNo, state);
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
		return Objects.equals(branch, other.branch) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(place, other.place) && Objects.equals(rollNo, other.rollNo)
				&& Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "StudentDataAndAddressDto [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", branch=" + branch
				+ ", state=" + state + ", place=" + place + "]";
	}

}
