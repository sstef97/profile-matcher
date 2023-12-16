package com.example.matcher.mapper;

import com.example.matcher.dto.CampaignDTO;
import com.example.matcher.dto.DoesNotHaveDTO;
import com.example.matcher.dto.HasDTO;
import com.example.matcher.dto.LevelDTO;
import com.example.matcher.dto.MatchersDTO;
import com.example.matcher.entity.Campaign;
import com.example.matcher.entity.DoesNotHave;
import com.example.matcher.entity.Has;
import com.example.matcher.entity.Level;
import com.example.matcher.entity.Matchers;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-14T00:39:15+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class CampaignMapperImpl implements CampaignMapper {

    @Override
    public Campaign campaignDTOToCampaign(CampaignDTO campaignDTO) {
        if ( campaignDTO == null ) {
            return null;
        }

        Campaign campaign = new Campaign();

        campaign.setName( campaignDTO.getName() );
        campaign.setGame( campaignDTO.getGame() );
        campaign.setPriority( campaignDTO.getPriority() );
        campaign.setMatchers( matchersDTOToMatchers( campaignDTO.getMatchers() ) );
        campaign.setStartDate( campaignDTO.getStartDate() );
        campaign.setEndDate( campaignDTO.getEndDate() );
        campaign.setEnabled( campaignDTO.isEnabled() );
        campaign.setLastUpdated( campaignDTO.getLastUpdated() );

        return campaign;
    }

    @Override
    public CampaignDTO campaignToCampaignDTO(Campaign campaign) {
        if ( campaign == null ) {
            return null;
        }

        CampaignDTO campaignDTO = new CampaignDTO();

        campaignDTO.setGame( campaign.getGame() );
        campaignDTO.setName( campaign.getName() );
        campaignDTO.setPriority( campaign.getPriority() );
        campaignDTO.setMatchers( matchersToMatchersDTO( campaign.getMatchers() ) );
        campaignDTO.setStartDate( campaign.getStartDate() );
        campaignDTO.setEndDate( campaign.getEndDate() );
        campaignDTO.setEnabled( campaign.isEnabled() );
        campaignDTO.setLastUpdated( campaign.getLastUpdated() );

        return campaignDTO;
    }

    protected Level levelDTOToLevel(LevelDTO levelDTO) {
        if ( levelDTO == null ) {
            return null;
        }

        int min = 0;
        int max = 0;

        min = levelDTO.getMin();
        max = levelDTO.getMax();

        Level level = new Level( min, max );

        return level;
    }

    protected Has hasDTOToHas(HasDTO hasDTO) {
        if ( hasDTO == null ) {
            return null;
        }

        List<String> country = null;
        List<String> items = null;

        List<String> list = hasDTO.getCountry();
        if ( list != null ) {
            country = new ArrayList<String>( list );
        }
        List<String> list1 = hasDTO.getItems();
        if ( list1 != null ) {
            items = new ArrayList<String>( list1 );
        }

        Has has = new Has( country, items );

        return has;
    }

    protected DoesNotHave doesNotHaveDTOToDoesNotHave(DoesNotHaveDTO doesNotHaveDTO) {
        if ( doesNotHaveDTO == null ) {
            return null;
        }

        List<String> items = null;

        List<String> list = doesNotHaveDTO.getItems();
        if ( list != null ) {
            items = new ArrayList<String>( list );
        }

        DoesNotHave doesNotHave = new DoesNotHave( items );

        return doesNotHave;
    }

    protected Matchers matchersDTOToMatchers(MatchersDTO matchersDTO) {
        if ( matchersDTO == null ) {
            return null;
        }

        Matchers matchers = new Matchers();

        matchers.setLevel( levelDTOToLevel( matchersDTO.getLevel() ) );
        matchers.setHas( hasDTOToHas( matchersDTO.getHas() ) );
        matchers.setDoesNotHave( doesNotHaveDTOToDoesNotHave( matchersDTO.getDoesNotHave() ) );

        return matchers;
    }

    protected LevelDTO levelToLevelDTO(Level level) {
        if ( level == null ) {
            return null;
        }

        LevelDTO levelDTO = new LevelDTO();

        levelDTO.setMin( level.getMin() );
        levelDTO.setMax( level.getMax() );

        return levelDTO;
    }

    protected HasDTO hasToHasDTO(Has has) {
        if ( has == null ) {
            return null;
        }

        HasDTO hasDTO = new HasDTO();

        List<String> list = has.getCountry();
        if ( list != null ) {
            hasDTO.setCountry( new ArrayList<String>( list ) );
        }
        List<String> list1 = has.getItems();
        if ( list1 != null ) {
            hasDTO.setItems( new ArrayList<String>( list1 ) );
        }

        return hasDTO;
    }

    protected DoesNotHaveDTO doesNotHaveToDoesNotHaveDTO(DoesNotHave doesNotHave) {
        if ( doesNotHave == null ) {
            return null;
        }

        DoesNotHaveDTO doesNotHaveDTO = new DoesNotHaveDTO();

        List<String> list = doesNotHave.getItems();
        if ( list != null ) {
            doesNotHaveDTO.setItems( new ArrayList<String>( list ) );
        }

        return doesNotHaveDTO;
    }

    protected MatchersDTO matchersToMatchersDTO(Matchers matchers) {
        if ( matchers == null ) {
            return null;
        }

        MatchersDTO matchersDTO = new MatchersDTO();

        matchersDTO.setLevel( levelToLevelDTO( matchers.getLevel() ) );
        matchersDTO.setHas( hasToHasDTO( matchers.getHas() ) );
        matchersDTO.setDoesNotHave( doesNotHaveToDoesNotHaveDTO( matchers.getDoesNotHave() ) );

        return matchersDTO;
    }
}
