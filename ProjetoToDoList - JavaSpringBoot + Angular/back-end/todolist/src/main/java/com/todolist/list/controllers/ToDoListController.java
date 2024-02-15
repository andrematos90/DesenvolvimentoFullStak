package com.todolist.list.controllers;
import com.todolist.list.model.ToDoListModel;
import com.todolist.list.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/to-do-list")
public class ToDoListController {

    @Autowired
    public ToDoListService toDoListService;



    @PostMapping
    public ResponseEntity<ToDoListModel> saveActivity(@RequestBody @Valid ToDoListModel toDoListModdel){

        return ResponseEntity.status(HttpStatus.CREATED).body(toDoListService.saveActivity(toDoListModdel));
    }
}
