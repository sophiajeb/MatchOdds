package com.match.matchodds.service;

import com.match.matchodds.dto.MatchOddsDto;

import java.util.List;
import java.util.Optional;

public interface MatchOddsService {

    List<MatchOddsDto> getAllOdds();

    Optional<MatchOddsDto> getOddById(Long id);

    MatchOddsDto createOdd(MatchOddsDto match);

    MatchOddsDto updateOdd(Long id, MatchOddsDto match);

    void deleteOdd(Long id);
}
