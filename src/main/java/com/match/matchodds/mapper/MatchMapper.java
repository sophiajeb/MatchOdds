package com.match.matchodds.mapper;

import com.match.matchodds.dto.MatchDto;
import com.match.matchodds.model.Match;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    MatchDto toDto(Match match);

    Match fromDto(MatchDto matchDto);

}
