package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GameListRepository extends CrudRepository<GameList, Long> {

    @Modifying
    @Query(nativeQuery = true,
    value = "UPDATE tb_belonging SET position =:newPosition WHERE list_id =:listId AND game_id=:gameId")

    void updateBelongingPosition(Long listId,Long gameId, Integer newPosition);


}
