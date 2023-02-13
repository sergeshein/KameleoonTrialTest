package com.shein.KameleoonTrialTest.service;

import com.shein.KameleoonTrialTest.dto.UserDTO;
import com.shein.KameleoonTrialTest.entity.User;

public interface UserService {
    User createUser(UserDTO userDTO);
    User findUserByEmail(String email);
}
