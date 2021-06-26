package com.example.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entity.Course;
import com.example.course.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository; 
	
	@RequestMapping("/course")
	public List<Course> courseList() {
		return courseRepository.findAll();

	}

	@RequestMapping("/course/duplicate")
	public List<Course> courseListDuplicate() {
		return courseRepository.findAll();

	}
	
	@RequestMapping(value = "/course/add", method = RequestMethod.POST)
	public List<Course> addCourse(@RequestBody Course course) {
		return courseRepository.add(course);
        
    }
	
	@RequestMapping(value = "/course/delete", method = RequestMethod.GET)
	public List<Course> addCourse(@RequestParam(value="id") Long id) {
		return courseRepository.remove(id);
        
    }

}
