package com.shein.KameleoonTrialTest.reository;

import com.shein.KameleoonTrialTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Получить пользователя по email
     * @param email адрес электронной почты
     * @return пользователь
     */
    User findByEmail(String email);
}