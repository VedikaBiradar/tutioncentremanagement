package com.vedikabiradar.sba_html_css_js.Controller;

import com.vedikabiradar.sba_html_css_js.Entity.Student;
import com.vedikabiradar.sba_html_css_js.Entity.User;
import com.vedikabiradar.sba_html_css_js.Service.StudentService;

import com.vedikabiradar.sba_html_css_js.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;



    @GetMapping("/studentRegister")
    public String showAddStudentForm(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("student", new Student());
        model.addAttribute("parentId"); // Replace with actual parentId
//        model.addAttribute("parents", parents);
        return "studentRegistration";
    }

    @PostMapping("/studentRegister")
    public String saveStudent(@ModelAttribute("student") Student student,
                            @RequestParam("parentId") Long parentId) {
        Optional<User> user= userService.getUserById(parentId);
        student.setUser(user.get());
        studentService.saveStudent(student);
        return "redirect:/studentRegister";
    }



    @GetMapping("/registeredStudent/list")
    public String listStudent(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "registeredStudents"; // Ensure this is the correct template name
    }

    @GetMapping("/deleteStudent")
    public String showDeleteStudentPage() {
        return "deleteStudent";
    }



    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Long studentId, Model model) {
        if (studentService.existsById(studentId)) {
            studentService.deleteById(studentId);
            model.addAttribute("successMessage", "Student deleted successfully.");
        } else {
            model.addAttribute("errorMessage", "Student ID is not valid.");
        }
        return "deleteStudent";
    }

}