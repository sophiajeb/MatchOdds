package com.match.matchodds.service;

import com.match.matchodds.dto.MatchOddsDto;
import com.match.matchodds.mapper.MatchOddsMapper;
import com.match.matchodds.mapper.OptionalUtils;
import com.match.matchodds.model.MatchOdds;
import com.match.matchodds.repository.MatchOddsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchOddsServiceImpl implements MatchOddsService {

    private final MatchOddsRepository oddsRepository;
    private final MatchOddsMapper matchOddsMapper;

    @Override
    public List<MatchOddsDto> getAllOdds() {
        return oddsRepository.findAll()
                .stream()
                .map(matchOddsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MatchOddsDto> getOddById(Long id) {
        MatchOdds matchOdds = OptionalUtils.unwrapOptional(oddsRepository.findById(id));
        return Optional.of(matchOddsMapper.toDto(matchOdds));
    }

    @Override
    public MatchOddsDto createOdd(MatchOddsDto odd) {
        MatchOdds matchOdds = matchOddsMapper.fromDto(odd);
        return matchOddsMapper.toDto(oddsRepository.save(matchOdds));
    }

    @Override
    public MatchOddsDto updateOdd(Long id, MatchOddsDto updatedOddDto) {

        MatchOdds updatedOdd = matchOddsMapper.fromDto(updatedOddDto);
        MatchOdds updated = oddsRepository.findById(id)
                .map(existing -> {
                    existing.setOdd(updatedOdd.getOdd());
                    existing.setSpecifier(updatedOdd.getSpecifier());
                    existing.setMatch(updatedOdd.getMatch());
                    return oddsRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Match not found with id " + id));

        return matchOddsMapper.toDto(updated);
    }

    @Override
    public void deleteOdd(Long id) {
        oddsRepository.deleteById(id);
    }
}
