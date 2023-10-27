package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.dto.StudentDataAndAddressDto;
import com.student.schema.StudentAddress;
import com.student.schema.StudentData;

@Service
public class StudentService {

	Logger log = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	MongoTemplate template;

	public StudentDataAndAddressDto insertStudentDataAndAddress(StudentDataAndAddressDto studentDetails) {

		StudentDataAndAddressDto allStudentDetails = new StudentDataAndAddressDto();

		try {
			// Create a StudentData object
			StudentData studentData = new StudentData();

			studentData.setId(studentDetails.getId());
			studentData.setName(studentDetails.getName());
			studentData.setBranch(studentDetails.getBranch());
			studentData.setRollNo(studentDetails.getRollNo());

			// Save StudentData to the StudentData collection
			StudentData insertedData = template.save(studentData);

			// Create a StudentAddress object
			StudentAddress studentAddress = new StudentAddress();
			studentAddress.setId(studentDetails.getId());
			studentAddress.setState(studentDetails.getState());
			studentAddress.setPlace(studentDetails.getPlace());

			// Save StudentAddress to the StudentAddress collection
			StudentAddress studentAddressAddedValue = template.save(studentAddress);

			ObjectMapper mapper = new ObjectMapper();

			allStudentDetails = mapper.convertValue(insertedData, StudentDataAndAddressDto.class);
			allStudentDetails.setState(studentAddressAddedValue.getState());
			allStudentDetails.setPlace(studentAddressAddedValue.getPlace());

		} catch (Exception e) {

			log.error(e.getMessage());
		}

		return allStudentDetails;
	}

	public List<StudentDataAndAddressDto> getAllTheStudentDetails() {

		List<StudentDataAndAddressDto> finalListOfStudentDetails = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper();

		try {

			List<StudentData> studentDataList = template.findAll(StudentData.class);
			List<StudentAddress> studentAddressList = template.findAll(StudentAddress.class);

			for (StudentData singleData : studentDataList) {

				StudentDataAndAddressDto studentAddressandData = new StudentDataAndAddressDto();

				for (StudentAddress singleStudentAddress : studentAddressList) {

					if ( singleData.getId().equals(singleStudentAddress.getId() ) ) {

						studentAddressandData = mapper.convertValue(singleData, StudentDataAndAddressDto.class);

						studentAddressandData.setState(singleStudentAddress.getState());
						studentAddressandData.setPlace(singleStudentAddress.getPlace());

						finalListOfStudentDetails.add(studentAddressandData);

					}
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return finalListOfStudentDetails;
	}
}
