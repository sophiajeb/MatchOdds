package com.match.matchodds.dto;

import lombok.Data;

@Data
public class MatchOddsDto {
    private Long id;
    private String specifier;
    private Double odd;
    private Long matchId;
}
