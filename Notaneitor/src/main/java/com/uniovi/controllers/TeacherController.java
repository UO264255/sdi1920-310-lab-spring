package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@RequestMapping("teacher/list")
	public String getList(Model model) {
		model.addAttribute("teacherList", teacherService.getTeacherList());
		return "/teacher/list";
	}

	@RequestMapping(value = "teacher/add", method = RequestMethod.POST)
	public String addTeacher(@ModelAttribute Teacher teacher) {
		teacherService.addTeacher(teacher);
		return"redirect:/teacher/list";
	}
	
	@RequestMapping(value = "teacher/add")
	public String getTeacher(@ModelAttribute Teacher teacher) {
		return"/teacher/add";
	}

	@RequestMapping(value = "teacher/edit", method = RequestMethod.POST)
	public String editTeacher(@ModelAttribute Teacher teacher) {
		teacherService.editTeacher(teacher);
		return"redirect:/teacher/list";
	}

	@RequestMapping(value = "teacher/details/{id}")
	public String getDetails(@PathVariable Long id, Model model) {
		model.addAttribute("teacher", teacherService.getTeacher(id));
		return "mark/details";
	}

	@RequestMapping(value = "teacher/delete/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
		return"redirect:/teacher/list";
	}

}
