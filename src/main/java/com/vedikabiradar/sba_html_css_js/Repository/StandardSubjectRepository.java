package com.vedikabiradar.sba_html_css_js.Repository;

import com.vedikabiradar.sba_html_css_js.Entity.StandardSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StandardSubjectRepository extends JpaRepository<StandardSubject, Long> {
    List<StandardSubject> findByStandard(String standard);
}
