/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples.services;

import edu.eci.cosw.samples.model.Tareas;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2087133
 */
@Service
public class TareasService {
    ConcurrentHashMap<String, Tareas> lista;

    public TareasService() {
        
        lista=new ConcurrentHashMap<>();
        
        //lista.put("nombre", new Tareas(10, "nombre"));
    }
    
    public void addTarea(Tareas t){
        lista.put(t.getNombre(), t);
    }
    
    public Tareas getDocumento(String nombre) throws DocumentNotFoundException{
        
        if (!lista.containsKey(nombre)){
            throw new DocumentNotFoundException("Documento ("+nombre+") no encontrado..." );
        }
        return lista.get(nombre);
    }
}
