package com.simhadri.studentapi.service;

import com.simhadri.studentapi.dto.StudentDTO;
import com.simhadri.studentapi.exception.InvalidInputException;
import com.simhadri.studentapi.exception.StudentNotFoundException;
import com.simhadri.studentapi.model.Student;
import com.simhadri.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
        return convertToDTO(student);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        validateStudent(studentDTO);
        Student student = convertToEntity(studentDTO);
        return convertToDTO(studentRepository.save(student));
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        validateStudent(studentDTO);
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Cannot update. Student with ID: " + id + " not found"));

        existingStudent.setName(studentDTO.getName());
        existingStudent.setAge(studentDTO.getAge());

        return convertToDTO(studentRepository.save(existingStudent));
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Cannot delete. Student with ID: " + id + " not found");
        }
        studentRepository.deleteById(id);
    }

    // DTO ↔ Entity converters
    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        return dto;
    }

    private Student convertToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        return student;
    }

    private void validateStudent(StudentDTO studentDTO) {
        if (studentDTO.getName() == null || studentDTO.getName().trim().isEmpty()) {
            throw new InvalidInputException("Name cannot be empty or null");
        }
        if (studentDTO.getAge() <= 0) {
            throw new InvalidInputException("Age must be greater than 0");
        }
    }
}
