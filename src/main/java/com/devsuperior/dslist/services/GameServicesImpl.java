package com.devsuperior.dslist.services;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServicesImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServicesImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return (List<Game>) this.gameRepository.findAll();
    }
}
