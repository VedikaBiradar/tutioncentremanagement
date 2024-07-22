    package com.vedikabiradar.sba_html_css_js.Controller;



    import com.vedikabiradar.sba_html_css_js.Dto.UserDto;
    import com.vedikabiradar.sba_html_css_js.Entity.Student;
    import com.vedikabiradar.sba_html_css_js.Entity.User;
    import com.vedikabiradar.sba_html_css_js.Service.StudentService;
    import com.vedikabiradar.sba_html_css_js.Service.UserService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.List;


    @Controller
    public class AuthorizeController {

        private UserService userService;

        @Autowired
        private StudentService studentService;

        @Autowired
        public AuthorizeController(UserService userService) {
           this.userService = userService;
        }


        @GetMapping("/login")
        public String loginForm()
        {
            return "login";
        }

        @GetMapping("/userRegistration")
        public String userRegistration(Model model){
            UserDto userDto =new UserDto();
            model.addAttribute("user", userDto);
            return "userRegistration";
        }

        @PostMapping("/userRegistration/save")
        public String saveRegistration(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
            User existing =userService.findUserByEmail(user.getEmail());
            if (existing != null) {
                result.rejectValue("email", null, "There is already an account registered with that email");
            }

            if (result.hasErrors()) {
                model.addAttribute("user", user);
                return "userRegistration";
            }

           userService.saveUser(user);
            return "redirect:/userRegistration?success";
        }


        @GetMapping("/users")
        public String listRegisteredUsers(Model model){
            List<UserDto> users= userService.findAllUsers();
            model.addAttribute("users", users);
            return "registeredUsers";

        }


        @GetMapping("/adminDashboard")
        public String adminDashboard() {
            return "adminDashboard";  // Ensure you have this template
        }

        @GetMapping("/parentDashboard")
        public String userDashboard() {
            return "parentDashboard";  // Ensure you have this template
        }

        @GetMapping("/studentInfo")
        public String showParentInfoForm(Model model) {
            model.addAttribute("email", "");
            return "studentInfo";
        }


        @PostMapping("/studentInfo")
        public String getParentInfo(@RequestParam("email") String email, Model model) {
            User user = userService.findByEmail(email);
            if (user != null) {
                List<Student> students = studentService.findByUser(user);
                model.addAttribute("student", students);
            } else {
                model.addAttribute("error", "No parent found with the provided email.");
            }
            model.addAttribute("email", email);
            return "studentInfo";
        }

        @GetMapping("/deleteParent")
        public String showDeleteParentPage() {
            return "deleteParent";
        }

        @PostMapping("/deleteParent")
        public String deleteParent(@RequestParam("email") String email, Model model) {
            if (email.endsWith("@admin.com")) {
                model.addAttribute("errorMessage", "This is an admin email, not able to delete.");
            } else if (!userService.deleteParentByEmail(email)) {
                model.addAttribute("errorMessage", "Invalid email, not present.");
            } else {
                model.addAttribute("successMessage", "Parent deleted successfully.");
            }
            return "deleteParent";
        }
    }





