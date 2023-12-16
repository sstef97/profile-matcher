package com.example.matcher.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MatchersDTO {
    private LevelDTO level;
    private HasDTO has;
    private DoesNotHaveDTO doesNotHave;
}
