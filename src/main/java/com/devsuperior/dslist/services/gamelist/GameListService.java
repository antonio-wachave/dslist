package com.devsuperior.dslist.services.gamelist;

import com.devsuperior.dslist.dto.GameListDTO;

import java.util.List;

public interface GameListService {

    List<GameListDTO> findAll();

    void move(Long listId, int sourceIndex, int destinationIndex);
}
