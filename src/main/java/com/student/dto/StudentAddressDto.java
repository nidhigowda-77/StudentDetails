package com.student.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StudentAddressDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("state")
    private String state;

    @JsonProperty("place")
    private String place;

    public StudentAddressDto() {
    }

    public StudentAddressDto(Integer id, String state, String place) {
        this.id = id;
        this.state = state;
        this.place = place;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
		return "StudentAddressDto [id=" + id + ", state=" + state + ", place=" + place + "]";
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
		StudentAddressDto other = (StudentAddressDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(place, other.place) && Objects.equals(state, other.state);
	}
    
}
