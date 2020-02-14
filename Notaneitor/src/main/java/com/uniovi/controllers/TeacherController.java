package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("teacher/list")
	public String getList() {
		return teacherService.getTeacherList().toString();
	}

	@RequestMapping(value = "teacher/add", method= RequestMethod.POST)
	public String addTeacher(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return "Ok";
	}
	
	@RequestMapping(value = "teacher/edit", method= RequestMethod.POST)
	public String editTeacher(@ModelAttribute Teacher teacher) {
		teacherService.editTeacher(teacher);
		return "Ok";
	}

	@RequestMapping(value = "teacher/details/{id}")
	public String getDetails(@PathVariable Long id) {
		return teacherService.getTeacher(id).toString();
	}
	
	@RequestMapping(value = "teacher/delete/{id}" )
	public String deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
		return "Ok";
	}	
	
}
