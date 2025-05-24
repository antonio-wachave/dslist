package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPk {

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name="list_id")
    private GameList gameList;

    public BelongingPk() {}

    public BelongingPk(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public String toString() {
        return "BelongingPk{" +
                "game=" + game +
                ", gameList=" + gameList +
                '}';
    }
}
