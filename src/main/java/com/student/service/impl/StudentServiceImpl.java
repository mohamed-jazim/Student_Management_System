package com.student.service.impl;

import com.student.entity.StudentEntity;
import com.student.exception.ResourceNotFoundException;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

   private StudentRepository repository;


    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public StudentEntity setdata(StudentEntity studentEntity) {
        return repository.save(studentEntity);
    }

    @Override
    public StudentEntity findViewById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student","id",id));
    }

    @Override
    public StudentEntity editStudent(StudentEntity studentEntity, long id) {
        StudentEntity existingStudent = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student","id",id));

        existingStudent.setEmail(studentEntity.getEmail());
        existingStudent.setFirst_name(studentEntity.getFirst_name());
        existingStudent.setSecond_name(studentEntity.getSecond_name());
        // Set other properties as needed

        return repository.save(existingStudent);
    }

    @Override
    public void deleteUser(long id) {
    StudentEntity entity = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("student","id",id));
    repository.deleteById(id);

    }


}
