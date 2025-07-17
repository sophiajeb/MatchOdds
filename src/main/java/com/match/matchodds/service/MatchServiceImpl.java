package com.match.matchodds.service;

import com.match.matchodds.dto.MatchDto;
import com.match.matchodds.mapper.MatchMapper;
import com.match.matchodds.mapper.OptionalUtils;
import com.match.matchodds.model.Match;
import com.match.matchodds.repository.MatchRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;


    @Override
    public List<MatchDto> getAllMatches() {
        return matchRepository.findAll()
                .stream()
                .map(matchMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MatchDto> getMatchById(Long id) {
        Match match = OptionalUtils.unwrapOptional(matchRepository.findById(id));
        return Optional.of(matchMapper.toDto(match));
    }

    @Override
    public MatchDto createMatch(MatchDto matchDto) {
        Match match = matchMapper.fromDto(matchDto);
        return matchMapper.toDto(matchRepository.save(match));
    }

    @Override
    public MatchDto updateMatch(Long id, MatchDto updatedMatchDto) {

        Match updatedMatch = matchMapper.fromDto(updatedMatchDto);
        Match updated = matchRepository.findById(id)
                .map(existing -> {
                    existing.setDescription(updatedMatch.getDescription());
                    existing.setMatchDate(updatedMatch.getMatchDate());
                    existing.setMatchTime(updatedMatch.getMatchTime());
                    existing.setTeamA(updatedMatch.getTeamA());
                    existing.setTeamB(updatedMatch.getTeamB());
                    existing.setSport(updatedMatch.getSport());
                    return matchRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Match not found with id " + id));

        return matchMapper.toDto(updated);
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
