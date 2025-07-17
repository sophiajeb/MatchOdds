package com.match.matchodds.mapper;

import com.match.matchodds.dto.MatchOddsDto;
import com.match.matchodds.model.Match;
import com.match.matchodds.model.MatchOdds;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatchOddsMapper {

    @Mapping(source = "match.id", target = "matchId")
    MatchOddsDto toDto(MatchOdds matchOdds);

    @Mapping(target = "match", expression = "java(toMatch(matchOddsDto.getMatchId()))")
    MatchOdds fromDto(MatchOddsDto matchOddsDto);

    default Match toMatch(Long id) {
        if (id == null) return null;
        Match match = new Match();
        match.setId(id);
        return match;
    }
}
