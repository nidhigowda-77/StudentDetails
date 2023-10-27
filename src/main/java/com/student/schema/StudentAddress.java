package com.student.schema;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentAddress")
public class StudentAddress {

	@Id
	private Integer rollNo;
	
	private String state;
	
	private String place;


	public Integer getRoll() {
		return rollNo;
	}
	public void setRoll(Integer rollNo) {
		this.rollNo = rollNo;
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
	public String toString() {
		return "StudentAddress [rollNo=" + rollNo + ", state=" + state + ", place=" + place + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(place, rollNo, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentAddress other = (StudentAddress) obj;
		return Objects.equals(place, other.place) && Objects.equals(rollNo, other.rollNo)
				&& Objects.equals(state, other.state);
	}


}
