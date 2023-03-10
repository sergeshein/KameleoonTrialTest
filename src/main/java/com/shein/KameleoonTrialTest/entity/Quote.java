package com.shein.KameleoonTrialTest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "quotes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Quote {

    private final static String SEQ_NAME = "quote_seq";
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(sequenceName = SEQ_NAME, name = SEQ_NAME, allocationSize = 1)
    private Long id;

    /**
     * Содержимое
     */
    @Column(name = "content", nullable = false)
    private String content;
    /**
     * Дата создания
     */
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    /**
     * Дата обновления
     */
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    /**
     * Связь с таблицей
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     * Оценка пользователя
     */
    @Column(name = "votes", nullable = false,
            columnDefinition = "int default 0")
    private int votes;
}
