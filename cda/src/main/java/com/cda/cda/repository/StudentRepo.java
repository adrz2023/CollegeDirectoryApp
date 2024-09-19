package com.cda.cda.repository;

import com.cda.cda.entity.StudentProfile;
import com.cda.cda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<StudentProfile,Long> {
    List<StudentProfile> findAllByYear(String year);

}
