package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository tRepo;

	@PostConstruct
	public void init() {
		tRepo.save(new Teacher(1L, "1232213D", "Alex", "Matas", "Category1"));
		tRepo.save(new Teacher(2L, "1232213D", "Angel", "Olmedo", "Category2"));
		tRepo.save(new Teacher(3L, "1232213D", "Guillermo", "Campoamor", "Category3"));
		tRepo.save(new Teacher(4L, "1232213D", "Hola", "Que tal", "No"));
	}

	public List<Teacher> getTeacherList() {
		List<Teacher> teachers = new ArrayList<Teacher>();
		tRepo.findAll().forEach(teachers::add);
		return teachers;
	}

	public Teacher getTeacher(Long id) {
		return tRepo.findById(id).get();
	}

	public void addTeacher(Teacher teacher) {
		tRepo.save(teacher);
	}

	public void editTeacher(Teacher teacherToReplace) {
		addTeacher(teacherToReplace);
	}

	public void deleteTeacher(Long id) {
		tRepo.deleteById(id);
	}

}
