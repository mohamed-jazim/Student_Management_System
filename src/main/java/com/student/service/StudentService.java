package com.student.service;

import com.student.entity.StudentEntity;
import com.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    List<StudentEntity> getAllStudents();

    //to add data
    StudentEntity setdata(StudentEntity studentEntity);

    //student find view by id
    StudentEntity findViewById(long id);

    StudentEntity editStudent(StudentEntity studentEntity, long id);

    void deleteUser(long id);


}
