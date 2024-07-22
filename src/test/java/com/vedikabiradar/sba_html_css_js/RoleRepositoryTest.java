package com.vedikabiradar.sba_html_css_js;


import com.vedikabiradar.sba_html_css_js.Entity.Role;
import com.vedikabiradar.sba_html_css_js.Repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testFindByName() {
        // given
        Role role = new Role();
        role.setName("ROLE_USER");
        roleRepository.save(role);

        // when
        Role found = roleRepository.findByName("ROLE_USER");

        // then
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("ROLE_USER");
    }

    @Test
    public void testSaveRole() {
        // given
        String roleName = "ROLE_ADMIN";

        // Check if the role already exists
        Role existingRole = roleRepository.findByName(roleName);
        if (existingRole == null) {
            Role role1 = new Role();
            role1.setName(roleName);

            // when
            Role savedRole = roleRepository.save(role1);

            // then
            Optional<Role> found = roleRepository.findById(savedRole.getId());
            assertThat(found).isPresent();
            assertThat(found.get().getName()).isEqualTo(roleName);
        } else {
            // Handle the case where the role already exists
            System.out.println("Role with name " + roleName + " already exists.");

        }
    }

    @Test
    public void testRoleNotFound() {
        // when
        Role found = roleRepository.findByName("ROLE_NON_EXISTENT");

        // then
        assertThat(found).isNull();
    }
}
