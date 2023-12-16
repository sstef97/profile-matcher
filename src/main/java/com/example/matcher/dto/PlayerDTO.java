package com.example.matcher.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class PlayerDTO {
    private String playerId;
    private String credential;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastSession;
    private int totalSpent;
    private int totalRefund;
    private int totalTransactions;
    private LocalDateTime lastPurchase;
    private List<String> activeCampaigns;
    private List<DeviceDTO> devices;
    private int level;
    private int xp;
    private int totalPlaytime;
    private String country;
    private String language;
    private LocalDateTime birthdate;
    private String gender;
    private Map<String, Integer> inventory;
    private ClanDTO clan;
    private String customField;
}
