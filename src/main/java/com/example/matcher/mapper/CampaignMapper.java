package com.example.matcher.mapper;

import com.example.matcher.dto.CampaignDTO;
import com.example.matcher.entity.Campaign;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampaignMapper {

    Campaign campaignDTOToCampaign(CampaignDTO campaignDTO);

    CampaignDTO campaignToCampaignDTO(Campaign campaign);
}