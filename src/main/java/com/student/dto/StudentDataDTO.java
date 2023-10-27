package com.student.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StudentDataDTO {
    
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    
    @JsonProperty("rollNo")
    private Long rollNo;

    @JsonProperty("branch")
    private String branch;

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

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "StudentDataDTO [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", branch=" + branch + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(branch, id, name, rollNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDataDTO other = (StudentDataDTO) obj;
		return Objects.equals(branch, other.branch) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(rollNo, other.rollNo);
	}

    
}
