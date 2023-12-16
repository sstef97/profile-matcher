package com.example.matcher.mapper;

import com.example.matcher.dto.ClanDTO;
import com.example.matcher.dto.DeviceDTO;
import com.example.matcher.dto.PlayerDTO;
import com.example.matcher.entity.Clan;
import com.example.matcher.entity.Device;
import com.example.matcher.entity.Player;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-14T00:39:15+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public Player playerDTOToPlayer(PlayerDTO playerDTO) {
        if ( playerDTO == null ) {
            return null;
        }

        Player player = new Player();

        player.setPlayerId( playerDTO.getPlayerId() );
        player.setCredential( playerDTO.getCredential() );
        player.setCreated( playerDTO.getCreated() );
        player.setModified( playerDTO.getModified() );
        player.setLastSession( playerDTO.getLastSession() );
        player.setTotalSpent( playerDTO.getTotalSpent() );
        player.setTotalRefund( playerDTO.getTotalRefund() );
        player.setTotalTransactions( playerDTO.getTotalTransactions() );
        player.setLastPurchase( playerDTO.getLastPurchase() );
        List<String> list = playerDTO.getActiveCampaigns();
        if ( list != null ) {
            player.setActiveCampaigns( new ArrayList<String>( list ) );
        }
        player.setDevices( deviceDTOListToDeviceList( playerDTO.getDevices() ) );
        player.setLevel( playerDTO.getLevel() );
        player.setXp( playerDTO.getXp() );
        player.setTotalPlaytime( playerDTO.getTotalPlaytime() );
        player.setCountry( playerDTO.getCountry() );
        player.setLanguage( playerDTO.getLanguage() );
        player.setBirthdate( playerDTO.getBirthdate() );
        player.setGender( playerDTO.getGender() );
        Map<String, Integer> map = playerDTO.getInventory();
        if ( map != null ) {
            player.setInventory( new LinkedHashMap<String, Integer>( map ) );
        }
        player.setClan( clanDTOToClan( playerDTO.getClan() ) );

        return player;
    }

    @Override
    public PlayerDTO playerToPlayerDTO(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerDTO playerDTO = new PlayerDTO();

        playerDTO.setPlayerId( player.getPlayerId() );
        playerDTO.setCredential( player.getCredential() );
        playerDTO.setCreated( player.getCreated() );
        playerDTO.setModified( player.getModified() );
        playerDTO.setLastSession( player.getLastSession() );
        playerDTO.setTotalSpent( (int) player.getTotalSpent() );
        playerDTO.setTotalRefund( (int) player.getTotalRefund() );
        playerDTO.setTotalTransactions( player.getTotalTransactions() );
        playerDTO.setLastPurchase( player.getLastPurchase() );
        List<String> list = player.getActiveCampaigns();
        if ( list != null ) {
            playerDTO.setActiveCampaigns( new ArrayList<String>( list ) );
        }
        playerDTO.setDevices( deviceListToDeviceDTOList( player.getDevices() ) );
        playerDTO.setLevel( player.getLevel() );
        playerDTO.setXp( player.getXp() );
        playerDTO.setTotalPlaytime( player.getTotalPlaytime() );
        playerDTO.setCountry( player.getCountry() );
        playerDTO.setLanguage( player.getLanguage() );
        playerDTO.setBirthdate( player.getBirthdate() );
        playerDTO.setGender( player.getGender() );
        Map<String, Integer> map = player.getInventory();
        if ( map != null ) {
            playerDTO.setInventory( new LinkedHashMap<String, Integer>( map ) );
        }
        playerDTO.setClan( clanToClanDTO( player.getClan() ) );

        return playerDTO;
    }

    protected Device deviceDTOToDevice(DeviceDTO deviceDTO) {
        if ( deviceDTO == null ) {
            return null;
        }

        Device device = new Device();

        device.setId( (long) deviceDTO.getId() );
        device.setModel( deviceDTO.getModel() );
        device.setCarrier( deviceDTO.getCarrier() );
        device.setFirmware( deviceDTO.getFirmware() );

        return device;
    }

    protected List<Device> deviceDTOListToDeviceList(List<DeviceDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Device> list1 = new ArrayList<Device>( list.size() );
        for ( DeviceDTO deviceDTO : list ) {
            list1.add( deviceDTOToDevice( deviceDTO ) );
        }

        return list1;
    }

    protected Clan clanDTOToClan(ClanDTO clanDTO) {
        if ( clanDTO == null ) {
            return null;
        }

        Clan clan = new Clan();

        clan.setId( clanDTO.getId() );
        clan.setName( clanDTO.getName() );

        return clan;
    }

    protected DeviceDTO deviceToDeviceDTO(Device device) {
        if ( device == null ) {
            return null;
        }

        DeviceDTO deviceDTO = new DeviceDTO();

        if ( device.getId() != null ) {
            deviceDTO.setId( device.getId().intValue() );
        }
        deviceDTO.setModel( device.getModel() );
        deviceDTO.setCarrier( device.getCarrier() );
        deviceDTO.setFirmware( device.getFirmware() );

        return deviceDTO;
    }

    protected List<DeviceDTO> deviceListToDeviceDTOList(List<Device> list) {
        if ( list == null ) {
            return null;
        }

        List<DeviceDTO> list1 = new ArrayList<DeviceDTO>( list.size() );
        for ( Device device : list ) {
            list1.add( deviceToDeviceDTO( device ) );
        }

        return list1;
    }

    protected ClanDTO clanToClanDTO(Clan clan) {
        if ( clan == null ) {
            return null;
        }

        ClanDTO clanDTO = new ClanDTO();

        clanDTO.setId( clan.getId() );
        clanDTO.setName( clan.getName() );

        return clanDTO;
    }
}
