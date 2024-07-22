package com.vedikabiradar.sba_html_css_js;

import com.vedikabiradar.sba_html_css_js.Entity.User;
import com.vedikabiradar.sba_html_css_js.Repository.UserRepository;
import com.vedikabiradar.sba_html_css_js.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest

public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl(userRepository, null, null); // No RoleRepository or PasswordEncoder needed for this test
    }

    @Test
    public void testFindUserById() {

        User user = new User();
        user.setUserName("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password"); // PasswordEncoder is not used in this test
        userRepository.save(user);

        Long userId = user.getId();


        Optional<User> foundUser = userService.getUserById(userId);

        assertTrue(foundUser.isPresent());
        assertEquals(userId, foundUser.get().getId());
        assertEquals("testuser", foundUser.get().getUserName());
        assertEquals("testuser@example.com", foundUser.get().getEmail());
    }
}
