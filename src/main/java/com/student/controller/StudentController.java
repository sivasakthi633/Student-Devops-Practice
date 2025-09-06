package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.modal.Student;

@Controller
public class StudentController {

	List<Student> studentList = new ArrayList<>();

	public StudentController() {
		studentList.add(new Student(1L, "Ravi", 83L, "coimbatore", 1L));
		studentList.add(new Student(2L, "Siva", 45L, "Tirupur", 9L));
		studentList.add(new Student(3L, "Sakthi", 99L, "Chennai", 5L));
	}

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentList);
		return "students";
	}

	@GetMapping("/students/new")
	public String addNewStudentPage(Model model) {
		Student student = new Student(0L, "", 0L, "", 0L);
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String addNewStudent(@ModelAttribute("student") Student student) {
		long newId = studentList.stream().map(Student::getId).max(Long::compareTo).orElse(0L) + 1;
		student.setId(newId);
		studentList.add(student);
		return "redirect:/students";
	}
	
//	@GetMapping("/students/edit/{id}")
//	public String editStudentPage(@PathVariable Long id, Model model) {
//		List<Student> editStudent = studentList.stream().filter(student -> student.getId() == id).collect(Collectors.toList());
//	    model.addAttribute("editStudent", editStudent);
//		return "student_edit_page";
//	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentPage(@PathVariable("id") Long id, Model model) {
	    Student student = studentList.stream()
	            .filter(s -> s.getId().equals(id))
	            .findFirst()
	            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	            
	    model.addAttribute("student", student);
	    return "student_edit_page";
	}

	
	@PostMapping("/students/edit/{id}")
	public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student studentDetails) {
	    Student existingStudent = studentList.stream()
	            .filter(s -> s.getId().equals(id))
	            .findFirst()
	            .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

	    existingStudent.setName(studentDetails.getName());
	    existingStudent.setMark(studentDetails.getMark());
	    existingStudent.setCity(studentDetails.getCity());
	    existingStudent.setClassNumber(studentDetails.getClassNumber());
	    
	    

	    return "redirect:/students";
	}
	
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
	    studentList.removeIf(student -> student.getId().equals(id));
	    return "redirect:/students";
	}


}
