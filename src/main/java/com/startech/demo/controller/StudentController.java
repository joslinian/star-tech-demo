package com.startech.demo.controller;

import com.startech.demo.persistence.Student;
import com.startech.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/get-students", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping(path = "/student-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Student getStudentById(@RequestParam("id") final Long id) {
        return service.getStudentById(id);
    }

    @PostMapping(path = "/add-account")
    @ResponseBody
    public void createStudentAccount(@RequestBody final Student student) {
        final Student studentToSave = new Student(student.getEmail(), student.getPassword(), student.getFirstName(), student.getLastName(), student.getDob(), student.getCreatedDate(), student.getModifiedDate());
        service.save(studentToSave);
    }

    @PostMapping(path = "/add-students", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void createStudentAccounts(@RequestBody final List<Student> students) {
        service.saveAll(students);
    }

}
