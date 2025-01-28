package com.wordtree.card;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cards")
public class Card {
    @Id
    @Column(name = "card_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="card_title",nullable = false)
    private String title;

    @Column(name="card_count",nullable = false)
    private int count;

    @Enumerated(EnumType.STRING)
    @Column(name="card_category",nullable = false)
    private Language language;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardWord> cardWords = new ArrayList<>();
}
