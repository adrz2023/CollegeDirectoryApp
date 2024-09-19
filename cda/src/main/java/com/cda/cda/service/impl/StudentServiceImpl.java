package com.cda.cda.service.impl;

import com.cda.cda.dto.department.DepartmentResponse;
import com.cda.cda.dto.students.StudentRequest;
import com.cda.cda.dto.students.StudentResponse;
import com.cda.cda.dto.users.UserResponse;
import com.cda.cda.entity.Department;
import com.cda.cda.entity.StudentProfile;
import com.cda.cda.entity.User;
import com.cda.cda.repository.DepartmentRepo;
import com.cda.cda.repository.StudentRepo;
import com.cda.cda.repository.UserRepo;
import com.cda.cda.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final UserRepo userRepo;
    private final DepartmentRepo departmentRepo;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper, UserRepo userRepo, DepartmentRepo departmentRepo) {
        this.studentRepo = studentRepo;
        this.userRepo = userRepo;
        this.departmentRepo = departmentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentResponse registerStudent(StudentRequest studentRequest) {
        StudentProfile studentProfile = new StudentProfile();
        User user = userRepo.findById(studentRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Department department = departmentRepo.findById(studentRequest.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department not found"));
        studentProfile.setUser(user);
        studentProfile.setDepartment(department);
        studentProfile.setYear(studentRequest.getYear());
        studentProfile.setPhoto(studentRequest.getPhoto());

        studentRepo.save(studentProfile);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setUserResponse(modelMapper.map(user, UserResponse.class));
        studentResponse.setPhoto(studentProfile.getPhoto());
        studentResponse.setYear(studentProfile.getYear());
        studentResponse.setDepartmentResponse(modelMapper.map(department, DepartmentResponse.class));

        return studentResponse;

    }

    @Override
    public StudentResponse getStudent(Long id) {
        StudentProfile studentProfile = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setUserResponse(modelMapper.map(studentProfile.getUser(), UserResponse.class));
        studentResponse.setPhoto(studentProfile.getPhoto());
        studentResponse.setYear(studentProfile.getYear());
        studentResponse.setDepartmentResponse(modelMapper.map(studentProfile.getDepartment(), DepartmentResponse.class));
        return studentResponse;
    }

    @Override
    public List<StudentResponse> getStudents(String year, String name) {

        if(name!=null){
            List<User> users=userRepo.findByName(name);
            return users.stream().map(user -> {
                StudentProfile studentProfile = new StudentProfile();
                studentProfile.setUser(user);
                return modelMapper.map(studentProfile, StudentResponse.class);
            }).toList();
        }

//        if(department!=null){
//            List<StudentProfile> studentProfiles=studentRepo.findByDepartment(department);
//            return studentProfiles.stream().map(studentProfile -> {
//                return modelMapper.map(studentProfile, StudentResponse.class);
//            }).toList();
//        }
        if(year!=null){
            List<StudentProfile> studentProfiles=studentRepo.findAllByYear(year);
            return studentProfiles.stream().map(studentProfile -> {

                UserResponse userResponse = modelMapper.map(studentProfile.getUser(), UserResponse.class);
                DepartmentResponse departmentResponse = modelMapper.map(studentProfile.getDepartment(), DepartmentResponse.class);

                StudentResponse studentResponse = new StudentResponse();
                studentResponse.setUserResponse(userResponse);
                studentResponse.setPhoto(studentProfile.getPhoto());
                studentResponse.setYear(studentProfile.getYear());
                studentResponse.setDepartmentResponse(departmentResponse);

                return studentResponse;


            }).toList();
        }


        List<StudentProfile> studentProfiles=studentRepo.findAll();
        return studentProfiles.stream().map(studentProfile -> {
            UserResponse userResponse = modelMapper.map(studentProfile.getUser(), UserResponse.class);
            DepartmentResponse departmentResponse = modelMapper.map(studentProfile.getDepartment(), DepartmentResponse.class);

            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setUserResponse(userResponse);
            studentResponse.setPhoto(studentProfile.getPhoto());
            studentResponse.setYear(studentProfile.getYear());
            studentResponse.setDepartmentResponse(departmentResponse);

            return studentResponse;
        }).toList();
    }
}
