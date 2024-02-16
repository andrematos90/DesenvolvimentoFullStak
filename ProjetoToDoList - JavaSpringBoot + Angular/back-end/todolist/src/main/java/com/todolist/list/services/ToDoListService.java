package com.todolist.list.services;

import com.todolist.list.model.ToDoListModel;
import com.todolist.list.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Transactional
    public ToDoListModel saveActivity(ToDoListModel toDoListModdel) {
        return toDoListRepository.save(toDoListModdel);
    }

    @Transactional
    public Optional<ToDoListModel> findActivityById(Integer id){
        return  toDoListRepository.findById(id);
    }

    @Transactional
    public void deleteActivity(ToDoListModel toDoListModel){
        toDoListRepository.delete(toDoListModel);
    }

}




