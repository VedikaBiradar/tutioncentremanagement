//package com.vedikabiradar.sba_html_css_js.Service;
//
//
//
//import com.vedikabiradar.sba_html_css_js.Repository.EmployeeRepository;
//import com.vedikabiradar.sba_html_css_js.Repository.ParentRepository;
//import com.vedikabiradar.sba_html_css_js.Entity.Employee;
//import com.vedikabiradar.sba_html_css_js.Entity.Parent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class LoginService {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Autowired
//    private ParentRepository parentRepository;
//
//    public boolean authenticate(String email, String password) {
//        if (email.endsWith("@admin.com")) {
//            Optional<Employee> employee = employeeRepository.findByEmployeeEmail(email);
//            return employee.isPresent() && employee.get().getEmployeePassword().equals(password);
//        } else {
//            Optional<Parent> parent = parentRepository.findByParentEmail(email);
//            return parent.isPresent() && parent.get().getParentPassword().equals(password);
//        }
//    }
//}
