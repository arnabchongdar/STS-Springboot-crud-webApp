package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;

	//list all the entries
	public List<Student> listAll() {
		return repo.findAll();
	}

	//find entries based on id
	public Optional<Student> get(int id) {
		return repo.findById(id);
	}

	//save the entries
	public Student save(Student std) {
		return repo.save(std);
	}

	//updating the entries
	public Optional<Student> updateStudent(Student newStudent, Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(user -> {
			user.setStudentname(newStudent.getStudentname());
			user.setCourse(newStudent.getCourse());
			user.setFee(newStudent.getFee());
			return repo.save(user);
		});
	}

	//delete entries   
	public String delete(int id) {
		repo.deleteById(id);
		return "entries deleted";
	}

}