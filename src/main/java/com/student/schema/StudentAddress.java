package com.student.schema;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentAddress")
public class StudentAddress {

	@Id
	private Integer id;

	private String state;
	private String place;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "StudentAddress [id=" + id + ", state=" + state + ", place=" + place + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, place, state);
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
		return Objects.equals(id, other.id) && Objects.equals(place, other.place) && Objects.equals(state, other.state);
	}

}
