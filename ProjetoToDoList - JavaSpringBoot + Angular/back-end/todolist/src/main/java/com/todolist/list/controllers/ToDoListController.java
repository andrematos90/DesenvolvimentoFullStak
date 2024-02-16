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
    public ResponseEntity<Object> getOneActivityById(@PathVariable(value = "id") Integer id){
        Optional<ToDoListModel> activity = toDoListService.findActivityById(id);
        if(!activity.isPresent()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(activity.get());

    }

    @GetMapping
    public ResponseEntity<List<ToDoListModel>> getAllActivitys(){
        return ResponseEntity.status(HttpStatus.OK).body(toDoListService.getAllActivitys());
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

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateToDoList(@PathVariable(value="id")Integer id, @RequestBody @Valid ToDoListModel toDoListModel){
        Optional<ToDoListModel> toDoListModelOptional = toDoListService.findActivityById(id);
        if(!toDoListModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não encontrada!");
        }
        else{

            ToDoListModel newData = toDoListModelOptional.get();

            newData.setActivity(toDoListModel.getActivity());
            newData.setDescription(toDoListModel.getDescription());
            newData.setCompleted(toDoListModel.getCompleted());
            newData.setDuration(toDoListModel.getDuration());
            newData.setDeadLine((toDoListModel.getDeadLine()));
            newData.setExceeded(toDoListModel.getExceeded());


            ToDoListModel atividadeAtualizada = toDoListService.saveActivity(newData);

            return  new ResponseEntity<>(toDoListModel, HttpStatus.OK);
        }
    }


}
