package com.example.matcher.service;

import com.example.matcher.dto.CampaignDTO;
import com.example.matcher.dto.PlayerDTO;
import com.example.matcher.entity.Campaign;
import com.example.matcher.entity.Player;
import com.example.matcher.mapper.CampaignMapper;
import com.example.matcher.mapper.PlayerMapper;
import com.example.matcher.repository.CampaignRepository;
import com.example.matcher.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final CampaignRepository campaignRepository;
    private final PlayerMapper playerMapper;
    private final CampaignMapper campaignMapper;

    public PlayerDTO getPlayerById(String playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));

        return playerMapper.playerToPlayerDTO(player);
    }
    public PlayerDTO updatePlayerBasedOnCampaign(String playerId, String campaignId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));

        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new EntityNotFoundException("Campaign not found"));

        // Check if the player matches the campaign conditions
        if (playerMatchesCampaign(player, campaign)) {
            // Update player based on campaign conditions
            player.getActiveCampaigns().add(campaign.getName());
            // Perform other updates as needed based on the campaign conditions

            // Save the updated player
            Player updatedPlayer = playerRepository.save(player);
            return playerMapper.playerToPlayerDTO(updatedPlayer);
        } else {
            // If player doesn't match campaign conditions, return current player state
            return playerMapper.playerToPlayerDTO(player);
        }
    }

   ///////
    ///
   public PlayerDTO getClientConfig(String playerId) {
        Player player = playerRepository.findByPlayerId(playerId);
        if (player == null) {
            throw new EntityNotFoundException("Player not found");
        }

        List<Campaign> campaigns = campaignRepository.findAllActiveCampaigns(); // Fetch active campaigns from the repository

        Campaign matchedCampaign = findMatchingCampaign(player, campaigns);

        if (matchedCampaign != null) {
            // Update player's active campaigns list
            if (!player.getActiveCampaigns().contains(matchedCampaign.getName())) {
                player.getActiveCampaigns().add(matchedCampaign.getName());
                playerRepository.save(player);
            }
        }

        return playerMapper.playerToPlayerDTO(player);
    }

    private Campaign findMatchingCampaign(Player player, List<Campaign> campaigns) {
        for (Campaign campaign : campaigns) {
            if (playerMatchesCampaign(player, campaign)) {
                return campaign;
            }
        }
        return null;
    }

    private boolean playerMatchesCampaign(Player player, Campaign campaign) {
        CampaignDTO campaignDTO = campaignMapper.campaignToCampaignDTO(campaign);
        PlayerDTO playerDTO = playerMapper.playerToPlayerDTO(player);

        // Compare player's attributes with campaign matchers using mapped DTOs
        return playerDTO.getLevel() >= campaignDTO.getMatchers().getLevel().getMin()
                && playerDTO.getLevel() <= campaignDTO.getMatchers().getLevel().getMax()
                && campaignDTO.getMatchers().getHas().getCountry().contains(playerDTO.getCountry())
                && !playerDTO.getInventory().keySet().containsAll(campaignDTO.getMatchers().getDoesNotHave().getItems());
    }
}
