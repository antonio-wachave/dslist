package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.Projections.GameMinProjection;
import com.devsuperior.dslist.entities.Game;

public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {}

    public GameMinDTO(Game GameEntity) {
    this.id = GameEntity.getId();
    this.title = GameEntity.getTitle();
    this.year = GameEntity.getYear();
    this.imgUrl = GameEntity.getImgUrl();
    this.shortDescription = GameEntity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection Projection) {
        this.id = Projection.getId();
        this.title = Projection.getTitle();
        this.year = Projection.getGameYear();
        this.imgUrl = Projection.getImgUrl();
        this.shortDescription = Projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "GameMinDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", imgUrl='" + imgUrl + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
