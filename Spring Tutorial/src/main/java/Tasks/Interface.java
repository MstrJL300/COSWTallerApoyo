/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 2087133
 */
public interface Interface {
    List <Tareas> consultTasks();
    void addTask (Tareas newTask);
    
}
