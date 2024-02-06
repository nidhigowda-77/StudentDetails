package com.student.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDataAndAddressDto;
import com.student.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Students", description = "End points related to student operations")
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * Get all the student details
     * @return ResponseEntity with a list of student details or an error response
     */
    @GetMapping
    @Cacheable(value = "cache")
    public ResponseEntity<?> getAllDetails() {
    	
        try {
        	
            List<StudentDataAndAddressDto> listOfAllTheStudentDetails = studentService.getAllTheStudentDetails();
            
            if(listOfAllTheStudentDetails.isEmpty()) {
            	
            	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Collection is empty");
            	
            } else {
            	
            	return ResponseEntity.status(HttpStatus.OK).body(listOfAllTheStudentDetails);
            }
            

            
        } catch ( Exception e ) {
        	
            e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Details not found");
        }
    }

    
    /**
     * Insert student details into the respective collections
     * @param studentData The student data to insert
     * @return ResponseEntity with the result or an error response
     */
    @PostMapping
    public ResponseEntity<?> addStudentDetails(@RequestBody StudentDataAndAddressDto studentData) {
    	
    	StudentDataAndAddressDto result = new StudentDataAndAddressDto();
    	
	    	boolean allFieldsNullOrEmpty = Stream.of(studentData.getCourse(), studentData.getYear(),studentData.getRollNo(), studentData.getState(),studentData.getBranch(),studentData.getName(), studentData.getPlace())
	    		    .anyMatch(field -> field == null || (field instanceof String && ((String) field).isEmpty()));
        try {
        	
        	 if ( allFieldsNullOrEmpty ) {
        		 
            	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Enter required fields ");
            } else {
            	
            	 result = studentService.insertStudentDataAndAddress( studentData );
            }
            
            return ResponseEntity.status(HttpStatus.OK).body( result );
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }
}
