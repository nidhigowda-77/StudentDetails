package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDataAndAddressDto;
import com.student.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDataAndAddressDto>> getAllDetails() {
        List<StudentDataAndAddressDto> listOfAllTheStudentDetails = studentService.getAllTheStudentDetails();
        return ResponseEntity.ok(listOfAllTheStudentDetails);
    }

    @PostMapping
    public ResponseEntity<?> addStudentDetails(@RequestBody StudentDataAndAddressDto studentData) {
        StudentDataAndAddressDto result = studentService.insertStudentDataAndAddress(studentData);
        return ResponseEntity.ok(result);
    }
}
