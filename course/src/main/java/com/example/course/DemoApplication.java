package com.example.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(courseRepository.findById(1L).toString());
	//	courseRepository.remove(2L);
//		System.out.println(courseRepository.findById(2L).toString());
		
	}
}
