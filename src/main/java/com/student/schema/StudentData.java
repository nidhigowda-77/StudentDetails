package com.student.schema;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentData")
public class StudentData {

	private Integer id;
	
	private String name;

	private Integer rollNo;
	
	private String branch;
	@Override
	public String toString() {
		return "StudentSchema [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", branch=" + branch + "]";
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
		StudentData other = (StudentData) obj;
		return Objects.equals(branch, other.branch) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(rollNo, other.rollNo);
	}

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

	public StudentData(Integer id, String name, Integer rollNo, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.branch = branch;
	}

	public StudentData() {
		super();
	}


}
