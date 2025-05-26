package com.devsuperior.dslist.services.gamelist;

import com.devsuperior.dslist.Projections.GameMinProjection;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListImpl implements GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;

    @Autowired
    public GameListImpl(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameListDTO> findAll() {

        List<GameList> result = (List<GameList>) this.gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map( x -> new GameListDTO(x)).toList();
        return dto;

    }

    @Override
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = this.gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++) {
            this.gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
