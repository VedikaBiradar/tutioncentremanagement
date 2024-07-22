package com.vedikabiradar.sba_html_css_js.Controller;

import com.vedikabiradar.sba_html_css_js.Entity.ContactMessage;
import com.vedikabiradar.sba_html_css_js.Entity.StandardSubject;
import com.vedikabiradar.sba_html_css_js.Service.ContactMessageService;
import com.vedikabiradar.sba_html_css_js.Service.StandardSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StandardSubjectController {

    private StandardSubjectService standardSubjectService;

    @Autowired
    public StandardSubjectController(StandardSubjectService standardSubjectService) {
        this.standardSubjectService = standardSubjectService;
    }

    @GetMapping("/standardSubject")
    public String showStandardSubjectForm(Model model) {
        model.addAttribute("standardSubject", new StandardSubject());
        return "standardSubject";
    }

    @PostMapping("/standardSubject")
    public String submitStandardSubjectForm(@ModelAttribute StandardSubject standardSubject) {
        standardSubjectService.saveStandardSubject(standardSubject);
        return "redirect:/standardSubject?success";
    }

    @GetMapping("/standardSubject/list")
    public String showListOfStandardSubject(Model model) {
        model.addAttribute("standardSubjects", standardSubjectService.getAllStandardSubjects());
        return "displayAllStandardSubjects";
    }



}
