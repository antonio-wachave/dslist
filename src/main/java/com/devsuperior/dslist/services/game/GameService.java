package com.devsuperior.dslist.services.game;

import com.devsuperior.dslist.dto.GameMinDTO;

import java.util.List;

public interface GameService {

    List<GameMinDTO> findAll();
    GameMinDTO findById(Long id);
}
