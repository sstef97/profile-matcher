package com.example.matcher.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Player {
    @Id
    private String playerId;
    private String credential;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastSession;
    private double totalSpent;
    private double totalRefund;
    private int totalTransactions;
    private LocalDateTime lastPurchase;
    private List<String> activeCampaigns;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "player_id")
    private List<Device> devices;
    private int level;
    private int xp;
    private int totalPlaytime;
    private String country;
    private String language;
    private LocalDateTime birthdate;
    private String gender;
    @ElementCollection
    @CollectionTable(name = "player_inventory", joinColumns = @JoinColumn(name = "player_id"))
    @MapKeyColumn(name = "item_name")
    @Column(name = "item_quantity")
    private Map<String, Integer> inventory;
    @OneToOne(cascade = CascadeType.ALL)
    private Clan clan;
    private String _customfield;
}
