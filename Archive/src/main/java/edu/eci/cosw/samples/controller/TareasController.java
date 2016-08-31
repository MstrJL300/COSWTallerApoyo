/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.samples.controller;

import edu.eci.cosw.samples.model.Tareas;
import edu.eci.cosw.samples.services.DocumentNotFoundException;
import edu.eci.cosw.samples.services.TareasService;
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
@RequestMapping(value = "/tareas")
public class TareasController {
    
    @Autowired
    TareasService ts = null;
    
    @RequestMapping(value = "/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<?> getDocumentById(@PathVariable("nombre") String val){
        try {
            Tareas tar = ts.getDocumento(val);
            
            return new ResponseEntity<>(tar,HttpStatus.ACCEPTED);
            
        } catch (DocumentNotFoundException ex) {
            
            Logger.getLogger(TareasController.class.getName()).log(Level.SEVERE, null, ex);
            
            return new ResponseEntity<>("No existe el documento:"+val,HttpStatus.NOT_FOUND);
        }        
    }
    //@RequestMapping(value = "/{ruta}", method = RequestMethod.GET)
    
    /**
     * EJEMPLO CURL:
     * curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/tareas -d '{"id":10, "nombre":"Nomb"}'
     * @param tar
     **/
    
    @RequestMapping(method = RequestMethod.POST)
    public void postNewDocument(@RequestBody(required = true) Tareas tar){
        
        ts.addTarea(tar);
    }
}
