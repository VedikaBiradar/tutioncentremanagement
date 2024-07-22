package com.vedikabiradar.sba_html_css_js.Service;

import com.vedikabiradar.sba_html_css_js.Entity.Student;

import com.vedikabiradar.sba_html_css_js.Entity.User;
import com.vedikabiradar.sba_html_css_js.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }


    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }


    public List<Student> getStudentByUser(User user) {
        return studentRepository.findByUser(user);
    }

    public List<Student> findByUser(User user) {
        return studentRepository.findByUser(user);
    }

    public boolean existsById(Long studentId) {
        return studentRepository.existsById(studentId);
    }

    public void deleteById(Long studentId) {
         studentRepository.deleteById(studentId);
    }
}