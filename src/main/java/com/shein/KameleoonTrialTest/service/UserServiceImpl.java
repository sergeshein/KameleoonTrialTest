package com.shein.KameleoonTrialTest.service;

import com.shein.KameleoonTrialTest.dto.UserDTO;
import com.shein.KameleoonTrialTest.entity.User;
import com.shein.KameleoonTrialTest.reository.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Реализация интерфейса UserService
 */
@Service
public class UserServiceImpl implements UserService {
//    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
  //      user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
