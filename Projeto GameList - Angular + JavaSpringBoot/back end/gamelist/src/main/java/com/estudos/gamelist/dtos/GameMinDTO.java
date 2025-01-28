package com.estudos.gamelist.dtos;

import com.estudos.gamelist.entities.Game;

public class GameMinDTO {

        Long id;
        String title;
        Integer year;
        String imgUrl;
        String shortDescription;


        public GameMinDTO(){

        }


    //ao inves de receber cada propriedade, o construr recebe uma entidade do tipo game e acessa o valor atraves dos gets
    public GameMinDTO(Game game) {
            id = game.getId();
            title = game.getTitle();
            year = game.getYear();
            imgUrl = game.getImgUrl();
            shortDescription = game.getShortDescription();
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
