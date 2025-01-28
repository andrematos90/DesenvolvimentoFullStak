package com.estudos.gamelist.dtos;

import com.estudos.gamelist.entities.Game;
import com.estudos.gamelist.projections.GameMinProjection;

public class GameMinDTO {

        Long id;
        String title;
        Integer year;
        String imgUrl;
        String shortDescription;


        public GameMinDTO(){

        }


    //ao inves de receber cada propriedade, o construr recebe uma entidade do tipo game e acessa o valor atraves dos gets
    public GameMinDTO(Game entity) {
            id = entity.getId();
            title = entity.getTitle();
            year = entity.getYear();
            imgUrl = entity.getImgUrl();
            shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }


}
