package com.vedikabiradar.sba_html_css_js;

import com.vedikabiradar.sba_html_css_js.Entity.StandardSubject;
import com.vedikabiradar.sba_html_css_js.Repository.StandardSubjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StandardSubjectRepositoryTest {

    @Autowired
    private StandardSubjectRepository standardSubjectRepository;

    @Test
    public void testFindByStandard() {
        // Arrange: Set up the data
        StandardSubject standardSubject1 = new StandardSubject("Grade 1", "Math");
        StandardSubject standardSubject2 = new StandardSubject("Grade 2", "Math");

        standardSubjectRepository.save(standardSubject1);
        standardSubjectRepository.save(standardSubject2);

        // Act: Call the method under test
        List<StandardSubject> result = standardSubjectRepository.findByStandard("Grade 1");

        // Assert: Verify the results
        assertThat(result.get(0).getSubject()).isEqualTo("Math");
    }
}
