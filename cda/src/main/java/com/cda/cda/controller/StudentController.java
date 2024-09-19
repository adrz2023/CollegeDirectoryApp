package com.cda.cda.controller;

import com.cda.cda.dto.students.StudentRequest;
import com.cda.cda.dto.students.StudentResponse;
import com.cda.cda.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/student-profiles")
    public ResponseEntity<StudentResponse> registerStudent(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.status(201).body(studentService.registerStudent(studentRequest));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponse>> getStudents(
//            @RequestParam(required = false) String department,
            @RequestParam(required = false) String year,
            @RequestParam(required = false) String name) {
        return ResponseEntity.ok(studentService.getStudents(year, name));
    }


}
