/*
 * Copyright (C) 2016 Pivotal Software, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cosw.samples.controller;

import edu.eci.cosw.samples.TextProcessor;
import edu.eci.cosw.samples.model.Documento;
import edu.eci.cosw.samples.services.DocumentNotFoundException;
import edu.eci.cosw.samples.services.DocumentServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/documentos")
public class DocumentsAPI {
    
    
    @Autowired
    TextProcessor tp=null;
    
    @Autowired
    DocumentServices ds=null;
    
    
    @RequestMapping(value = "/{titulodoc}", method = RequestMethod.GET)
    public ResponseEntity<?> getDocumentById(@PathVariable("titulodoc") String val){
        try {
            Documento doc = ds.getDocumento(val);
            
            doc.setContenido(tp.processText(doc.getContenido()));
            
            return new ResponseEntity<>(doc,HttpStatus.ACCEPTED);
            
        } catch (DocumentNotFoundException ex) {
            
            Logger.getLogger(DocumentsAPI.class.getName()).log(Level.SEVERE, null, ex);
            
            return new ResponseEntity<>("No existe el documento:"+val,HttpStatus.NOT_FOUND);
        }        
    }
    
// curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/documentos -d '{"titulo":"eltitulo", "contenido":"el contenido aaaa bbbb ccc"}'
    
    @RequestMapping(method = RequestMethod.POST)
    public void postNewDocument(@RequestBody(required = true) Documento doc){
        
        ds.addDocument(doc);
    }
}
