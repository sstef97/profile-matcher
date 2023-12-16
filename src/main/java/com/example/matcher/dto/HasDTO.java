package com.example.matcher.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class HasDTO {
    private List<String> country;
    private List<String> items;
}
