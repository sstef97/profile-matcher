package com.example.matcher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Level {
    @Column(name = "min_level")
    private final int min;

    @Column(name = "max_level")
    private final int max;
}
