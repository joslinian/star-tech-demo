package com.startech.demo.service;

import com.startech.demo.persistence.Student;
import com.startech.demo.repository.StudentRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return Lists.newArrayList(repository.findAll());
    }

    public List<Student> getStudentById(final Long id) {
        return repository.findAllById(Lists.newArrayList(id));
    }

    public void save(final Student student) {
        repository.save(student);
    }

    public void saveAll(final List<Student> students) {
        repository.saveAll(students);
    }

    public void delete(final Long id) {
        final Student student = repository.findById(id).orElse(null);
        repository.delete(student);
    }
}
