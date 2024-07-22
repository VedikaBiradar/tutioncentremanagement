package com.vedikabiradar.sba_html_css_js;

import com.vedikabiradar.sba_html_css_js.Entity.User;
import com.vedikabiradar.sba_html_css_js.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // Given
        User user = new User();
        user.setUserName("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");
        userRepository.save(user);

        // When
        User foundUser = userRepository.findByEmail("testuser@example.com");

        // Then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("testuser@example.com");
    }

    @Test
    public void testExistsByEmail() {
        // Given
        User user = new User();
        user.setUserName("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");
        userRepository.save(user);

        // When
        boolean exists = userRepository.existsByEmail("testuser@example.com");

        // Then
        assertThat(exists).isTrue();

        // Additional test cases
        boolean doesNotExist = userRepository.existsByEmail("nonexistent@example.com");
        assertThat(doesNotExist).isFalse();
    }


    @Test
    public void testDeleteByEmail() {
        // Given
        User user = new User();
        user.setUserName("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");
        userRepository.save(user);

        // Ensure the user is saved
        assertThat(userRepository.existsByEmail("testuser@example.com")).isTrue();

        // When
        userRepository.deleteByEmail("testuser@example.com");

        // Then
        // Verify the user has been deleted
        boolean existsAfterDeletion = userRepository.existsByEmail("testuser@example.com");
        assertThat(existsAfterDeletion).isFalse();
    }

}
