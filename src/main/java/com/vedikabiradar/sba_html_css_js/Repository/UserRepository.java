package com.vedikabiradar.sba_html_css_js.Repository;


import com.vedikabiradar.sba_html_css_js.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    boolean existsByEmail(String email);

    void deleteByEmail(String email);
}
