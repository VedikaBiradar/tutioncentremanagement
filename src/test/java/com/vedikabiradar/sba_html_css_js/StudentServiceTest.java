package com.vedikabiradar.sba_html_css_js;

import com.vedikabiradar.sba_html_css_js.Entity.Student;
import com.vedikabiradar.sba_html_css_js.Repository.StudentRepository;
import com.vedikabiradar.sba_html_css_js.Service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;



    @Test
    public void testSaveStudent() {

        //create student and check
        Student student = new Student();
        student.setStudentName("John Doe");
        student.setDob(LocalDate.of(2000, 1, 1));
        student.setBloodGroup("O+");
        student.setDaysPerWeek(5);
        student.setGender("Male");
        student.setStandard("10");
        student.setUser(null);

        //to save data using student service method
        Student savedStudent = studentService.saveStudent(student);

        // Assert to check correct data is there or not
        assertEquals(student.getStudentName(), savedStudent.getStudentName());
        assertEquals(student.getDob(), savedStudent.getDob());
        assertEquals(student.getBloodGroup(), savedStudent.getBloodGroup());
        assertEquals(student.getDaysPerWeek(), savedStudent.getDaysPerWeek());
        assertEquals(student.getGender(), savedStudent.getGender());
        assertEquals(student.getStandard(), savedStudent.getStandard());
    }
}
