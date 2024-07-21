//package com.vedikabiradar.sba_html_css_js.Controller;
//
//
//import com.vedikabiradar.sba_html_css_js.Entity.Parent;
//import com.vedikabiradar.sba_html_css_js.Service.ParentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class RegistrationController {
//
//    @Autowired
//    private ParentService parentService;
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("parent", new Parent());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String registerParent(Parent parent) {
//        parentService.saveParent(parent);
//        return "redirect:/register?success";
//    }
//
//    @GetMapping("/parents")
//    public String listParents(Model model) {
//        model.addAttribute("parents", parentService.getAllParents());
//        return "parentList";
//    }
//}
//
