package com.spring.docker.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.spring.docker.entity.Student;
import com.spring.docker.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentResource
{
    @Autowired
    private StudentRepository studentRepository;
    
    /**
     * 
     */
    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
	    return studentRepository.findAll();
    }

    /**
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable long id) throws Exception {
	    Optional<Student> student = studentRepository.findById(id);

	    if (!student.isPresent()) throw new Exception("id-" + id);
	    return student.get();
    }

    /**
     * 
     * @param id
     */
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
	    studentRepository.deleteById(id);
    }

    /**
     * 
     * @param student
     * @return
     */
    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
	    Student savedStudent = studentRepository.save(student);

	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(savedStudent.getId()).toUri();
	    return ResponseEntity.created(location).build();

    }

    /**
     * 
     * @param student
     * @param id
     * @return
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
	    Optional<Student> studentOptional = studentRepository.findById(id);

	    if (!studentOptional.isPresent()) return ResponseEntity.notFound().build();
        student.setId(id);
	    studentRepository.save(student);
        return ResponseEntity.noContent().build();
    }
}   