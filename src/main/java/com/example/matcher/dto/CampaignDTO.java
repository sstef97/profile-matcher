package com.example.matcher.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CampaignDTO {
    private String game;
    private String name;
    private double priority;
    private MatchersDTO matchers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean enabled;
    private LocalDateTime lastUpdated;
}
