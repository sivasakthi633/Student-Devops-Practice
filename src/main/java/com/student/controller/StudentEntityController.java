package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.StudentEntity;
import com.student.repository.StudentEntityRepository;

@RestController
@RequestMapping("/api/students")
public class StudentEntityController {

	@Autowired
	private StudentEntityRepository studentRepository;

	// ✅ Get all students
	@GetMapping
	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	// ✅ Get student by ID
	@GetMapping("/{id}")
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
		return studentRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// ✅ Create new student
	@GetMapping("/create-student")
	public StudentEntity createStudent() {
		StudentEntity student = new StudentEntity();
	    student.setName("Siva");
	    student.setEmail("sivasakthi@gmail.com");
	    student.setAge(23);
		return studentRepository.save(student);
	}


}
