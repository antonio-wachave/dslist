package com.devsuperior.dslist.services.gamelist;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameListImpl implements GameListService {

    private final GameListRepository gameListRepository;

    @Autowired
    public GameListImpl(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Override
    public List<GameListDTO> findAll() {

        List<GameList> result = (List<GameList>) this.gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map( x -> new GameListDTO(x)).toList();
        return dto;

    }
}
