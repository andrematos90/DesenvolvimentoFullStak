package com.todolist.list.controllers;
import com.todolist.list.model.ToDoListModel;
import com.todolist.list.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/to-do-list")
public class ToDoListController {

    @Autowired
    public ToDoListService toDoListService;



    @PostMapping
    public ResponseEntity<ToDoListModel> saveActivity(@RequestBody @Valid ToDoListModel toDoListModdel){

        return ResponseEntity.status(HttpStatus.CREATED).body(toDoListService.saveActivity(toDoListModdel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getActivityById(@PathVariable(value = "id") Integer id){
        Optional<ToDoListModel> activity = toDoListService.findActivityById(id);
        if(!activity.isPresent()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(activity.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteActivity(@PathVariable(value = "id") Integer id, @RequestBody @Valid ToDoListModel toDoListModel){
        Optional<ToDoListModel> toDoListModelOptional = toDoListService.findActivityById(id);
        if(!toDoListModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não encontrada!");
        }
        toDoListService.deleteActivity(toDoListModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Registro Excluido!");
    }


}
