package com.todolist.list.services;

import com.todolist.list.model.ToDoListModel;
import com.todolist.list.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Transactional
    public ToDoListModel saveActivity(ToDoListModel toDoListModdel){
        return  toDoListRepository.save(toDoListModdel);
    }
}
