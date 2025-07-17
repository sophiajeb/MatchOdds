package com.match.matchodds.controller;

import com.match.matchodds.dto.MatchOddsDto;
import com.match.matchodds.service.MatchOddsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/odds")
@RequiredArgsConstructor
public class MatchOddsController {

    private final MatchOddsService oddsService;

    @GetMapping
    public List<MatchOddsDto> getAllOdds() {
        return oddsService.getAllOdds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchOddsDto> getOddById(@PathVariable Long id) {
        return oddsService.getOddById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MatchOddsDto createOdd(@RequestBody MatchOddsDto odd) {
        return oddsService.createOdd(odd);
    }

    @PutMapping("/{id}")
    public MatchOddsDto updateOdd(@PathVariable Long id, @RequestBody MatchOddsDto odd) {
        return oddsService.updateOdd(id, odd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        oddsService.deleteOdd(id);
        return ResponseEntity.noContent().build();
    }
}
