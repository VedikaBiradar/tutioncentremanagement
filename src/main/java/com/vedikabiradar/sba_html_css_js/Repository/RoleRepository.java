package com.vedikabiradar.sba_html_css_js.Repository;

import com.vedikabiradar.sba_html_css_js.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}