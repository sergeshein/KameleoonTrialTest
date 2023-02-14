package com.shein.KameleoonTrialTest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private final static String SEQ_NAME = "user_seq";

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(sequenceName = SEQ_NAME, name = SEQ_NAME, allocationSize = 1)
    private Long id;
    /**
     * Логин (имя пользователя)
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * Адрес электронной почты
     */
    @Column(name = "email",
            nullable = false,
            unique = true)
    private String email;
    /**
     * Пароль
     */
    @Column(name = "password", nullable = false)
    @ToString.Exclude
    private String password;

    /**
     * Дата создания
     */
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
