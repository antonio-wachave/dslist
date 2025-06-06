package com.devsuperior.dslist.services.game;

import com.devsuperior.dslist.Projections.GameMinProjection;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return result.stream().map( x -> new GameMinDTO(x)).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public GameMinDTO findById(Long id) {
        Game result = this.gameRepository.findById(id).get();
        return new GameMinDTO(result);
    }

    @Override
    @Transactional
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = this.gameRepository.searchByList(listId);
        return result.stream().map( x -> new GameMinDTO(x)).toList();
    }
}
