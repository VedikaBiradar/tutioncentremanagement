//package com.vedikabiradar.sba_html_css_js.Controller;
//
//import com.vedikabiradar.sba_html_css_js.Entity.LoginForm;
//import com.vedikabiradar.sba_html_css_js.Service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private LoginService loginService;
//
//    @GetMapping("/loginparentadmin")
//    public String showLoginForm(Model model) {
//        model.addAttribute("loginForm", new LoginForm());
//        return "login";
//    }
//
//    @PostMapping("/loginparentadmin")
//    public String login(@RequestParam("email") String email,
//                        @RequestParam("password") String password,
//                        Model model) {
//        boolean isAuthenticated = loginService.authenticate(email, password);
//
//        if (isAuthenticated) {
//            return "redirect:/home";  // Redirect to some page after successful login
//        } else {
//            model.addAttribute("errorMessage", "Invalid email or password");
//            return "login";
//        }
//    }
//}
//
