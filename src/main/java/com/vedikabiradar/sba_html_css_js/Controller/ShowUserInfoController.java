package com.vedikabiradar.sba_html_css_js.Controller;



import com.vedikabiradar.sba_html_css_js.Entity.User;
import com.vedikabiradar.sba_html_css_js.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowUserInfoController {

    @Autowired
    private UserService userService; // Assuming you have a UserService to fetch user details

    @GetMapping("/userinfo")
    public String showUserInfoForm(Model model) {
        model.addAttribute("email", new String());
        return "userinfo";
    }

    @PostMapping("/userinfo")
    public String getUserInfo(@RequestParam("email") String email, Model model) {
        User user = userService.findByEmail(email);
        if (user != null) {
            model.addAttribute("user", user);
            return "userinfo";
        } else {
            model.addAttribute("error", "User not found");
            return "userinfo";
        }
    }
}