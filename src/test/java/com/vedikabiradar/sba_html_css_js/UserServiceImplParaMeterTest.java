package com.vedikabiradar.sba_html_css_js;

import com.vedikabiradar.sba_html_css_js.Entity.User;
import com.vedikabiradar.sba_html_css_js.Repository.UserRepository;
import com.vedikabiradar.sba_html_css_js.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserServiceImplParaMeterTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {

        User user = new User();
        user.setUserName("user1");
        user.setEmail("user1@example.com");
        user.setPassword("1235");
        user.setFirstName("John");
        user.setLastName("Doe");

        userRepository.save(user);
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1@example.com", "nonexistent@example.com"})
    void testFindByEmail(String email) {
        User user = userService.findUserByEmail(email);

        if (email.equals("user1@example.com")) {
            assertEquals("user1", user.getUserName());
            assertEquals("John", user.getFirstName());
            assertEquals("Doe", user.getLastName());
        } else {
            assertNull(user);
        }
    }
}
