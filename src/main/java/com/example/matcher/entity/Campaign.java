package com.example.matcher.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Campaign {
    @Id
    private final String name;
    private String game;
    private double priority;
    @Embedded
    private Matchers matchers;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean enabled;
    private LocalDateTime lastUpdated;

}