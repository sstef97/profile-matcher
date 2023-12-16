package com.example.matcher.repository;

import com.example.matcher.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, String> {
    @Query("SELECT c FROM Campaign c WHERE c.enabled = true AND c.startDate <= CURRENT_TIMESTAMP AND c.endDate >= CURRENT_TIMESTAMP")
    List<Campaign> findAllActiveCampaigns();
}
