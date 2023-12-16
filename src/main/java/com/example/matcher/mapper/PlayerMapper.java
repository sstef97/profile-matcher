package com.example.matcher.mapper;

import com.example.matcher.dto.PlayerDTO;
import com.example.matcher.entity.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player playerDTOToPlayer(PlayerDTO playerDTO);

    PlayerDTO playerToPlayerDTO(Player player);
}
