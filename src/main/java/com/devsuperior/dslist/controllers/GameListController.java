package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.game.GameService;
import com.devsuperior.dslist.services.gamelist.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @Autowired
    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping("/gamelists")
    public List<GameListDTO> findAll() {
        return this.gameListService.findAll();
    }

    @GetMapping("/gamelists/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return this.gameService.findByList(listId);
    }

    @PutMapping("/gamelists/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        this.gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
