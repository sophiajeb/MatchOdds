package com.match.matchodds.service;

import com.match.matchodds.dto.MatchDto;
import com.match.matchodds.model.Match;

import java.util.List;
import java.util.Optional;

public interface MatchService {

    List<MatchDto> getAllMatches();

    Optional<MatchDto> getMatchById(Long id);

    MatchDto createMatch(MatchDto match);

    MatchDto updateMatch(Long id, MatchDto match);

    void deleteMatch(Long id);
}
