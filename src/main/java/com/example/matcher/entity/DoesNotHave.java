package com.example.matcher.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Embeddable
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class DoesNotHave {
    @ElementCollection
    @CollectionTable(name = "player_items", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "item")
    private final List<String> items;
}
