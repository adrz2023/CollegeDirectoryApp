package com.cda.cda.service;


import com.cda.cda.dto.students.StudentRequest;
import com.cda.cda.dto.students.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse registerStudent(StudentRequest studentRequest);

    StudentResponse getStudent(Long id);

    List<StudentResponse> getStudents(String year, String name);
}