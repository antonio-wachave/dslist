package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.repository.CrudRepository;

public interface GameListRepository extends CrudRepository<GameList, Long> {
}
