package com.devmanoj.service;

import com.devmanoj.entity.Student;
import com.devmanoj.repository.StudentRepo;
import com.devmanoj.exception.StudentNotFoundException;
import com.devmanoj.dto.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;


    public StudentResponseDTO saveStudent(Student student) {

        Student saved = repo.save(student);
        return stdToDto(saved);
    }


    public StudentResponseDTO findById(Integer studentId)
            throws StudentNotFoundException {

        Student student = repo.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + studentId));

        return stdToDto(student);
    }


    public List<StudentResponseDTO> findAll() {

        return repo.findAll()
                .stream()
                .map(this::stdToDto)
                .collect(Collectors.toList());
    }


    public StudentResponseDTO updateStudent(Integer studentId, Student newStudent)
        throws StudentNotFoundException {

    Student existing = repo.findById(studentId)
            .orElseThrow(() ->
                    new StudentNotFoundException("Student not found with id: " + studentId));
	if (newStudent.getName() != null)
        existing.setName(newStudent.getName());

    if (newStudent.getEnglish() != null)
        existing.setEnglish(newStudent.getEnglish());

    if (newStudent.getHindi() != null)
        existing.setHindi(newStudent.getHindi());

    if (newStudent.getMath() != null)
        existing.setMath(newStudent.getMath());

    if (newStudent.getScience() != null)
        existing.setScience(newStudent.getScience());

    Student updated = repo.save(existing);

    return stdToDto(updated);
}

	public void deleteById(Integer studentId)
            throws StudentNotFoundException {

        Student student = repo.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + studentId));

        repo.delete(student);
    }

	private StudentResponseDTO stdToDto(Student student) {

        int total = student.getEnglish()
                + student.getHindi()
                + student.getMath()
                + student.getScience();

       double percentage = Math.round((total / 4.0) * 100.0) / 100.0;

        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setStudentId(student.getStudentId());
        dto.setName(student.getName());
        dto.setTotalMarks(total);
        dto.setPercentage(percentage);

        return dto;
    }
}