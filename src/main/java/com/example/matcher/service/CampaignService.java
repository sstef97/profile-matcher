package com.example.matcher.service;

import com.example.matcher.entity.Campaign;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CampaignService {

    public List<Campaign> getCurrentCampaigns() {
        List<Campaign> campaigns = new ArrayList<>();

        Campaign campaign1 = new Campaign("Campaign 1");
        Campaign campaign2 = new Campaign("Campaign 2");
        Campaign campaign3 = new Campaign("Campaign 3");

        campaigns.add(campaign1);
        campaigns.add(campaign2);
        campaigns.add(campaign3);

        return campaigns;
    }
}
