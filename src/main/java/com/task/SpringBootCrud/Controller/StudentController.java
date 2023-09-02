package com.task.SpringBootCrud.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.SpringBootCrud.model.Student;
import com.task.SpringBootCrud.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/students")
	public String createNewStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Student Created in database";
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> stuList = new ArrayList<>();
		studentRepository.findAll().forEach(stuList::add);
		return new ResponseEntity<List<Student>>(stuList, HttpStatus.OK);

	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) {
		Optional<Student> stu = studentRepository.findById(id);
		if (stu.isPresent()) {
			return new ResponseEntity<Student>(stu.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/students/{id}")
	public String updateStudentById(@PathVariable long id,@RequestBody Student student) {
		Optional<Student> stu = studentRepository.findById(id);
		if (stu.isPresent()) {
			Student existStu = stu.get();
			existStu.setName(student.getName());
			existStu.setSubject(student.getSubject());
			existStu.setMarks(student.getMarks());
			existStu.setContact(student.getContact());
			studentRepository.save(existStu);
			return "Student details against id " + id + " updated";
		} else {
			return "Student Details does not exist for id " + id;
		}
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudentById(@PathVariable long id) {
		studentRepository.deleteById(id);
		return "Student deleted Succesfully";
		
	}
	@DeleteMapping("/students")
	public String  deleteAllStudent() {
		studentRepository.deleteAll();
		return "Employee delted Sucessfully";
	}
}
