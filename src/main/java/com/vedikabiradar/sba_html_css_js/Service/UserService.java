package com.vedikabiradar.sba_html_css_js.Service;
import com.vedikabiradar.sba_html_css_js.Entity.User;


import com.vedikabiradar.sba_html_css_js.Dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();

    List<User> getAllUsers();

    Optional<User> getUserById(Long parentId);

    User findByEmail(String email);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);

    boolean deleteParentByEmail(String email);
}