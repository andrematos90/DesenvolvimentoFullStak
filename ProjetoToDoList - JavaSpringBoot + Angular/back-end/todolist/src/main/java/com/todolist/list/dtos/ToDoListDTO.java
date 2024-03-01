package com.todolist.list.dtos;

import jakarta.persistence.Column;

import java.time.Duration;
import java.time.LocalDate;

public class ToDoListDTO {

    private String activity;
    private boolean completed;
    private boolean exceeded;

    private LocalDate deadLine;

    public ToDoListDTO() {
    }

    public ToDoListDTO(String activity, boolean completed, boolean exceeded, Duration duration, LocalDate deadLine) {
        this.activity = activity;
        this.completed = completed;
        this.exceeded = exceeded;

        this.deadLine = deadLine;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isExceeded() {
        return exceeded;
    }

    public void setExceeded(boolean exceeded) {
        this.exceeded = exceeded;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }
}
