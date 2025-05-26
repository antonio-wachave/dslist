package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPk belongingPk = new BelongingPk();
    private Integer position;

    public Belonging() {}

    public Belonging(Game game, GameList gameList, Integer position) {
        belongingPk.setGame(game);
        belongingPk.setGameList(gameList);
        this.position = position;
    }

    public BelongingPk getBelongingPk() {
        return belongingPk;
    }

    public void setBelongingPk(BelongingPk belongingPk) {
        this.belongingPk = belongingPk;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Belonging{" +
                "belongingPk=" + belongingPk +
                ", position=" + position +
                '}';
    }
}
