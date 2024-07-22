package com.vedikabiradar.sba_html_css_js.Repository;


import com.vedikabiradar.sba_html_css_js.Entity.Student;

import com.vedikabiradar.sba_html_css_js.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByUser(User user);

}