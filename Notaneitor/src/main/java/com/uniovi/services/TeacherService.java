package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;

@Service
public class TeacherService {

	List<Teacher> teacherList = new LinkedList<Teacher>();

	@PostConstruct
	public void init() {
		teacherList.add(new Teacher(1L, "1232213D", "Alex", "Matas", "Category1"));
		teacherList.add(new Teacher(2L, "1232213D", "Angel", "Olmedo", "Category2"));
		teacherList.add(new Teacher(3L, "1232213D", "Guillermo", "Campoamor", "Category3"));
		teacherList.add(new Teacher(4L, "1232213D", "Hola", "Que tal", "No"));
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public Teacher getTeacher(Long id) {
		return teacherList.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().get();
	}

	public void addTeacher(Teacher teacher) {
		if (teacher.getId() == null) {
			teacher.setId(teacherList.get(teacherList.size() - 1).getId() + 1);
		}
		
		teacherList.add(teacher);
	}
	
	public void editTeacher(Teacher teacherToReplace) {
		Teacher teach = teacherList.stream().filter(teacher -> teacher.getId().equals(teacherToReplace.getId())).findFirst().get();
		int index = teacherList.indexOf(teach);
		teacherList.set(index,teacherToReplace);
	}

	public void deleteTeacher(Long id) {
		teacherList.removeIf(teacher-> teacher.getId().equals(id));
	}
	
}
