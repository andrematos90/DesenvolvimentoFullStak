package com.estudos.gamelist.entities;

import jakarta.persistence.*;

import java.util.Objects;

//notation que configura a classe para que ela seja equivalente a uma tabela do banco
@Entity
//define o nome da tabela
@Table(name = "Tb_game")
public class Game {

    //define o id como chave primaria
    @Id
    //autoincremeta o id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    //altera o nome da coluna
    @Column(name = "game_year")
    private Integer year;

    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    //define que o campo recebe texto e nao apenas string de 255 caracteres
    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    //construtor sem parametros
    public Game(){

    }

    //construtor com parametros
    public Game(
            Long id,
            String title,
            Integer year,
            String genre,
            String platforms,
            Double score,
            String imgUrl,
            String shortDescription,
            String longDescription
    ){
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    //métodos getter e setters

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return  title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Integer getYear(){
        return year;
    }

    public void setYear(Integer year){
        this.year = year;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getPlatforms(){
        return platforms;
    }

    public void setPlatforms(String platforms){
        this.platforms = platforms;
    }

    public Double getScore(){
        return score;
    }

    public void setScore(Double score){
        this.score = score;
    }

    public String getImgUrl(){
        return  imgUrl;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    public String getShortDescription(){
        return shortDescription;
    }

    public void setShortDescription(String shortDescription){
        this.shortDescription = shortDescription;
    }

    public String getLongDescription(){
        return  longDescription;
    }

    public void setLongDescription(String longDescription){
        this.longDescription = longDescription;
    }

    //métodos para comparar games
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Game game)) return false;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
