package com.example.matcher.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DeviceDTO {
    private int id;
    private String model;
    private String carrier;
    private String firmware;
}
