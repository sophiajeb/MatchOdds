package com.match.matchodds.controller;

import com.match.matchodds.dto.MatchDto;
import com.match.matchodds.mapper.MatchMapper;
import com.match.matchodds.model.Match;
import com.match.matchodds.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public List<MatchDto> getAllMatches() {

        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MatchDto createMatch(@RequestBody MatchDto match) {
        return matchService.createMatch(match);
    }

    @PutMapping("/{id}")
    public MatchDto updateMatch(@PathVariable Long id, @RequestBody MatchDto match) {
        return matchService.updateMatch(id, match);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
