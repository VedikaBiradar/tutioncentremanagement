//package com.vedikabiradar.sba_html_css_js.Controller;
//
//
//
//import com.vedikabiradar.sba_html_css_js.Entity.Employee;
//import com.vedikabiradar.sba_html_css_js.Service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import jakarta.validation.Valid;
//
//@Controller
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
////        @GetMapping("/index")
////    public String showIndexForm(Model model) {
////        return "index";
////    }
//
//    @GetMapping("/employeeRegistration")
//    public String showEmployeeRegistrationForm(Model model) {
//        model.addAttribute("employee", new Employee());
//        return "employeeRegistration";
//    }
//
//    @PostMapping("/employeeRegistration")
//    public String registerEmployee(@Valid Employee employee, Model model) {
//        if (!employee.getEmployeeEmail().endsWith("@admin.com")) {
//            model.addAttribute("emailError", "Email must end with @admin.com");
//            return "employeeRegistration";
//        }
//        employeeService.saveEmployee(employee);
//        return "redirect:/employeeRegistration?success";
//    }
//
//    @GetMapping("/employeeList")
//    public String listEmployees(Model model) {
//        model.addAttribute("employees", employeeService.getAllEmployees());
//        return "employeeList";
//    }
//
//
//}
//
