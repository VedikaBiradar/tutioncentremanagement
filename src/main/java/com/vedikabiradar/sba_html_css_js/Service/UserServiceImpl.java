package com.vedikabiradar.sba_html_css_js.Service;

import com.vedikabiradar.sba_html_css_js.Dto.UserDto;
import com.vedikabiradar.sba_html_css_js.Entity.User;
import com.vedikabiradar.sba_html_css_js.Entity.Role;
import com.vedikabiradar.sba_html_css_js.Repository.UserRepository;
import com.vedikabiradar.sba_html_css_js.Repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setState(userDto.getState());
        user.setCountry(userDto.getCountry());
        user.setZip(userDto.getZip());


        //Determine the role based on registration criteria
        String roleName;
        if(userDto.isAdminRegistration()){
            roleName = "ROLE_ADMIN";
        }else{
            roleName= "ROLE_PARENT";
        }

        //Check if role already exists in database, otherwise create it
        Role role = roleRepository.findByName(roleName);
        if(role == null) {
            role = new Role();
            role.setName((roleName));
            roleRepository.save(role);
        }

        //Assign the role to the user
        user.setRoles((Collections.singletonList(role)));
        userRepository.save(user);
    }




    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users= userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users=userRepository.findAll();
        return List.of();
    }

    @Override
    public Optional<User> getUserById(Long parentId) {
       Optional<User> user= userRepository.findById(parentId);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);

    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setState(user.getState());
        userDto.setCountry(user.getCountry());
        userDto.setZip(user.getZip());

        return userDto;
    }

    @Transactional
    public boolean deleteParentByEmail(String email) {
        var user = userRepository.findByEmail(email);
        if (user != null) {
            user.getRoles().clear();  // Disassociate roles
            userRepository.delete(user);
            return true;
        }
        return false;
    }


}