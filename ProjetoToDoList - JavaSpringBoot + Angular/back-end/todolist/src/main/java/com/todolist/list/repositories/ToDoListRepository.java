package com.todolist.list.repositories;

import com.todolist.list.model.ToDoListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListModel, Integer> {
}
