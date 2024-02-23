package com.student.Student.Record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.student")
@EnableFeignClients(basePackages = "com.student.feign")
public class StudentRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRecordApplication.class, args);
	}
	

}
