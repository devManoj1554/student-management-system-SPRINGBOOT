package com.devmanoj.controller;

import com.devmanoj.service.StudentService;
import com.devmanoj.entity.Student;
import com.devmanoj.exception.StudentNotFoundException;
import com.devmanoj.dto.StudentResponseDTO;
import com.devmanoj.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping
    public ResponseEntity<ResponseStatus<StudentResponseDTO>> saveStudent(@RequestBody Student student) {

        StudentResponseDTO dto = service.saveStudent(student);

        ResponseStatus<StudentResponseDTO> response = new ResponseStatus<>(201, "Student created successfully", dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

	@PutMapping("/{studentId}")
	public ResponseEntity<ResponseStatus<StudentResponseDTO>> updateStudent(@PathVariable Integer studentId, @RequestBody Student student) throws StudentNotFoundException
	{

		StudentResponseDTO dto = service.updateStudent(studentId, student);

		ResponseStatus<StudentResponseDTO> response = new ResponseStatus<>(200, "Student updated successfully", dto);

    return ResponseEntity.ok(response);
}

    @GetMapping("/{studentId}")
    public ResponseEntity<ResponseStatus<StudentResponseDTO>> getStudent(@PathVariable Integer studentId) throws StudentNotFoundException
	{

        StudentResponseDTO dto = service.findById(studentId);

        ResponseStatus<StudentResponseDTO> response = new ResponseStatus<>(200, "Student fetched successfully", dto);

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<ResponseStatus<List<StudentResponseDTO>>> getAllStudents() {

        List<StudentResponseDTO> dtoList = service.findAll();

        ResponseStatus<List<StudentResponseDTO>> response = new ResponseStatus<>(200, "All students fetched successfully", dtoList);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ResponseStatus<String>> deleteStudent(@PathVariable Integer studentId) throws StudentNotFoundException
	{

        service.deleteById(studentId);

        ResponseStatus<String> response = new ResponseStatus<>(200, "Student deleted successfully", "Deleted ID: " + studentId);

        return ResponseEntity.ok(response);
    }
}