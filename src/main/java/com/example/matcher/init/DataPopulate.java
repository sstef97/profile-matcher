package com.example.matcher.init;

import com.example.matcher.entity.*;
import com.example.matcher.repository.CampaignRepository;
import com.example.matcher.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataPopulate implements CommandLineRunner {

    private final CampaignRepository campaignRepository;
    private final PlayerRepository playerRepository;
    @Override
    public void run(String... args) {
        Campaign campaign = new Campaign("Campaign 1");
        campaign.setGame("mygame");
        campaign.setPriority(10.5);
        Matchers matchers = new Matchers();
        matchers.setLevel(new Level(1, 3));
        matchers.setHas(new Has(Arrays.asList("US", "RO", "CA"), List.of("item_1")));
        matchers.setDoesNotHave(new DoesNotHave(List.of("item_4")));
        campaign.setMatchers(matchers);
        campaign.setStartDate(LocalDateTime.parse("2022-01-25T00:00:00"));
        campaign.setEndDate(LocalDateTime.parse("2022-02-25T00:00:00"));
        campaign.setEnabled(true);
        campaign.setLastUpdated(LocalDateTime.parse("2021-07-13T11:46:58"));

        campaignRepository.save(campaign);

        Player player = getPlayer();
        playerRepository.save(player);
    }

    private static Player getPlayer() {
        Player player = new Player();
        Device device = new Device();
        device.setId(1L);
        device.setModel("apple iphone 11");
        device.setCarrier("vodafone");
        device.setFirmware("123");


        player.setPlayerId("97983be2-98b7-11e7-90cf-082e5f28d836");
        player.setCredential("apple_credential");
        player.setCreated(LocalDateTime.parse("2021-01-10T13:37:17"));
        player.setModified(LocalDateTime.parse("2021-01-23T13:37:17"));
        player.setLastSession(LocalDateTime.parse("2021-01-23T13:37:17"));
        player.setTotalSpent(400);
        player.setTotalRefund(0);
        player.setTotalTransactions(5);
        player.setLastPurchase(LocalDateTime.parse("2021-01-22T13:37:17"));
        player.setActiveCampaigns(List.of("My Campaign"));
        player.setDevices(List.of(device));
        player.setLevel(3);
        player.setXp(1000);


        player.setCountry("CA");
        player.setLanguage("fr");

        return player;
    }
}

