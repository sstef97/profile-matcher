package com.example.matcher.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@RequiredArgsConstructor
public class Matchers {
    @Embedded
    private Level level;
    @Embedded
    private Has has;
    @Embedded
//    @AttributeOverride(name = "items", column = @Column(name = "doesNotHaveItems"))
    private DoesNotHave doesNotHave;
}
