package com.vedikabiradar.sba_html_css_js.Controller;

import com.vedikabiradar.sba_html_css_js.Entity.Child;
import com.vedikabiradar.sba_html_css_js.Entity.User;
import com.vedikabiradar.sba_html_css_js.Repository.ChildRepository;
import com.vedikabiradar.sba_html_css_js.Service.ChildService;

import com.vedikabiradar.sba_html_css_js.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ChildController {

    @Autowired
    private ChildService childService;

    @Autowired
    private UserService userService;



    @GetMapping("/childRegister")
    public String showAddChildForm(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("child", new Child());
        model.addAttribute("parentId"); // Replace with actual parentId
//        model.addAttribute("parents", parents);
        return "childRegistration"; // Assuming "childRegistrationForm" is your template
    }

    @PostMapping("/childRegister")
    public String saveChild(@ModelAttribute("child") Child child,
                            @RequestParam("parentId") Long parentId) {
        Optional<User> user= userService.getUserById(parentId);
        child.setUser(user.get());
        childService.saveChild(child);
        return "redirect:/childRegister";
    }

//    @GetMapping("/registeredChildren/list")
//    public String listChildren(Model model) {
//
////        model.addAttribute("child", childService.getAllChildren());
////        return "registeredChildren";
//
//        List<Child> child = childService.getAllChildren();
//        model.addAttribute("child", child);
//        return "registeredChildren"; // Assuming "registered children.html" is your template
////    }

    @GetMapping("/registeredChildren/list")
    public String listChildren(Model model) {
        List<Child> children = childService.getAllChildren();
        model.addAttribute("children", children); // Use "children" instead of "child"
        return "registeredChildren"; // Ensure this is the correct template name
    }

    @GetMapping("/deleteChild")
    public String showDeleteChildPage() {
        return "deleteChild";
    }



    @PostMapping("/deleteChild")
    public String deleteChild(@RequestParam("childId") Long childId, Model model) {
        if (childService.existsById(childId)) {
            childService.deleteById(childId);
            model.addAttribute("successMessage", "Child deleted successfully.");
        } else {
            model.addAttribute("errorMessage", "Child ID is not valid.");
        }
        return "deleteChild";
    }

}