package com.vedikabiradar.sba_html_css_js.Repository;


import com.vedikabiradar.sba_html_css_js.Entity.Child;

import com.vedikabiradar.sba_html_css_js.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByUser(User user);

}