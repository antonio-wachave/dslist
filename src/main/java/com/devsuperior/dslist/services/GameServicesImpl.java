package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServicesImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServicesImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameMinDTO> findAll() {

        List<Game> result = (List<Game>) gameRepository.findAll();

        List<GameMinDTO> dto = result.stream().map( x -> new GameMinDTO(x)).toList();

        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public GameMinDTO findById(Long id) {
        Game result = this.gameRepository.findById(id).get();
        return new GameMinDTO(result);
    }
}
