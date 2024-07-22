package com.vedikabiradar.sba_html_css_js.Service;

import com.vedikabiradar.sba_html_css_js.Entity.StandardSubject;
import com.vedikabiradar.sba_html_css_js.Repository.StandardSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardSubjectService {
    @Autowired
    private StandardSubjectRepository standardSubjectRepository;

    public void saveStandardSubject(StandardSubject standardSubject) {
        standardSubjectRepository.save(standardSubject);
    }

    public List<StandardSubject> getAllStandardSubjects() {
        return standardSubjectRepository.findAll();
    }

    public Object findByStandard(String standard) {
        return standardSubjectRepository.findByStandard(standard);
    }
}
