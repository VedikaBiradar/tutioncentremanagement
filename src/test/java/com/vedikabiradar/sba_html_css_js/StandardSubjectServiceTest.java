package com.vedikabiradar.sba_html_css_js;

import com.vedikabiradar.sba_html_css_js.Entity.StandardSubject;
import com.vedikabiradar.sba_html_css_js.Repository.StandardSubjectRepository;
import com.vedikabiradar.sba_html_css_js.Service.StandardSubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StandardSubjectServiceTest {

    @Autowired
    private StandardSubjectService standardSubjectService;

    @Autowired
    private StandardSubjectRepository standardSubjectRepository;

    @Test
    void testSaveStandardSubject() {
        StandardSubject standardSubject = new StandardSubject();
        standardSubject.setStandard("Grade 1");
        standardSubject.setSubject("Mathematics");

        standardSubjectService.saveStandardSubject(standardSubject);

        // Fetch the saved entity and check if it exists
        StandardSubject fetchedStandardSubject = standardSubjectRepository.findById(standardSubject.getId()).orElse(null);

        assertTrue(fetchedStandardSubject != null && fetchedStandardSubject.equals(standardSubject));
    }
}
