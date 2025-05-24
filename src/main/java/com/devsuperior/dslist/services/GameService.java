package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;

import java.util.List;

public interface GameService {

    List<GameMinDTO> findAll();
}
