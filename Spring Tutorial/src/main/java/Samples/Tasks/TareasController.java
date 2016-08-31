/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Samples.Tasks;

import Samples.Tasks.Interface;
import Samples.Tasks.DocumentNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2087133
 */
@RestController
//@RequestMapping(value = "/tasks")
public class TareasController {
    
    @Autowired
    Interface taskService;
    /**
     * Returns the tasks registered on the system
     * @return 
     */
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List <Tareas> listAllTasks(){
        taskService.addTask(new Tareas(10, "nombre"));
        List <Tareas> tasks = taskService.consultTasks();
        return tasks;
    }
    /**
     * Creates a new Task on the system
     * @param task Task to be added
     * @return 
     * EJEMPLO CURL:
     * curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/tasks -d '{"id":10, "nombre":"nombre"}'
     */
    /*@RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<Void> createTask (@RequestBody Tareas task){
        taskService.addTask(task);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }*/
    
}
