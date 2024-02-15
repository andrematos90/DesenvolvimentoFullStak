package com.todolist.list.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Table(name = "TB_TODO_LIST")
public class ToDoListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String activity;
    @Column(nullable = false, unique = true)
    private String description;
    private boolean completed;

    private boolean exceeded;
    @Convert(converter = DurationConverter.class)
    private Duration duration;
    private LocalDate deadLine;


    public ToDoListModel(){}

    public ToDoListModel(Integer id,
                         String activity,
                         String description,
                         boolean completed,
                         boolean exceeded,
                         Duration duration,
                         LocalDate deadLine){
        this.id = id;
        this.activity = activity;
        this.description = description;
        this.completed = completed;
        this.exceeded = exceeded;
        this.duration = duration;
        this.deadLine = deadLine;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getActivity(){
        return  this.activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDescription(){
        return  this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean getCompleted(){
        return this.completed;
    }

    public void  setCompleted(boolean completed){
        this.completed = completed;
    }

    public boolean getExceeded(){
        return this.exceeded;
    }

    public void setExceeded(boolean exceeded){
        this.exceeded = exceeded;
    }

    public Duration getDuration(){
        return  this.duration;
    }

    public void setDuration(Duration duration){
        this.duration = duration;
    }

    public LocalDate getDeadLine(){
        return this.deadLine;
    }

    public void setDeadLine(LocalDate deadLine){
        this.deadLine = deadLine;
    }
}
