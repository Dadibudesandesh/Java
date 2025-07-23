package com.example.todoApp.Controller;

import com.example.todoApp.Entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allow React to call Spring
public class TodoController {
     private List<Todo> todos = new ArrayList<>();

     @GetMapping("/getAll")
    public List<Todo> getAll(){
         return todos;
     }

     @GetMapping("/get/{id}")
     public Todo getTodo(@PathVariable("id") int todoId){
         for (Todo todo:todos){
             if (todo.getId()==todoId)
                 return todo;
         }
         return null;
     }

     @PostMapping("/addTodo")
    public Todo addTodo(@RequestBody Todo newTodo){
         todos.add(newTodo);
         return newTodo;
     }

     @PostMapping("/addTodos")
     public List<Todo> addTodos(@RequestBody List<Todo> newTodos){
         todos.addAll(newTodos);
         return newTodos;
     }

     @DeleteMapping("/remove/{id}")
    public Todo removeTodo(@PathVariable("id") int  todoId) {
         Iterator<Todo> todoIterator = todos.iterator();

         while (todoIterator.hasNext()) {
             Todo todo = todoIterator.next();
             if (todo.getId() == todoId) {
                 todoIterator.remove();
                 return todo;
             }
         }
         return null;
     }


     @PutMapping("update/{id}")
    public Todo updateTodo(@PathVariable("id") int todoId,@RequestBody Todo updatedTodo){
         for (Todo todo:todos){
             if (todo.getId()==todoId){
                 todo.setId(updatedTodo.getId());
                 todo.setTitle(updatedTodo.getTitle());
                 todo.setDesc(updatedTodo.getDesc());

                 return todo;
             }
         }
         return null;
     }

}
