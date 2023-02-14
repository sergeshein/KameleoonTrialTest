package com.shein.KameleoonTrialTest.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "votes")
public class Vote {
    private final static String SEQ_NAME = "vote_seq";
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(sequenceName = SEQ_NAME, name = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "vote_type", nullable = false)
    private VoteType voteType;

    @ManyToOne
    @JoinColumn(name = "quote_id", referencedColumnName = "id")
    private Quote quote;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
