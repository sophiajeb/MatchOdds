package com.match.matchodds.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "match_odds")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchOdds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specifier;

    private Double odd;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
}
