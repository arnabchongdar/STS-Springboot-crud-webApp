package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;

	// get all entries
	@GetMapping("/")

	public List<Student> getAllStudents() {
		return service.listAll();

	}

	//get entries based on id
	@GetMapping("/{id}")
	Optional<Student> getAllStudent(@PathVariable Integer id) {
		return service.get(id);

	}

	// post mapping,submitting entries

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student std) {
		service.save(std);
		return service.save(std);
	}

	// editing the entries

	@PutMapping("/edit/{id}")
	Optional<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
		return service.updateStudent(student, id);

	}

	// deleting the entries
	@DeleteMapping("/delete/{id}")
	public String deletestudent(@PathVariable Integer id) {
		service.delete(id);
		return service.delete(id);
	}
}
