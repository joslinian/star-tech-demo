package com.startech.demo.service;

import com.startech.demo.persistence.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void save(Student student);
    void saveAll(List<Student> students);
    void delete(Long id);
}
