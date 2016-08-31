/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Samples.Tasks;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2093182
 */
@Service 
public class ServicioTareaStub implements Interface {
    
    private  List <Tareas> tasks = new ArrayList<>();
   
    @Override
    public List<Tareas> consultTasks() {
        return  tasks;
    }

    @Override
    public void addTask(Tareas newTask) {
        tasks.add(newTask);
    }
    
}
