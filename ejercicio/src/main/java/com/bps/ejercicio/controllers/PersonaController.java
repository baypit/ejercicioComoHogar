package com.bps.ejercicio.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bps.ejercicio.dao.PersonaDao;
import com.bps.ejercicio.models.Persona;
import com.bps.ejercicio.utils.JWTUtil;

@RestController
public class PersonaController {

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private JWTUtil jwtUtil;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "api/personas", method = RequestMethod.GET)
    public List<Persona> getUProductos() {

        return personaDao.getPersonas();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "api/registroPersona", method = RequestMethod.POST)
    public void registrarProducto(@RequestBody Persona persona) {

    	personaDao.registrar(persona);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "api/listarPersonaId", method = RequestMethod.POST)
    public Persona listarPersonaId(@RequestBody int id){
        return personaDao.obtenerPersonaPorID(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "api/editarPersona", method = RequestMethod.POST)
    public void editarProducto(@RequestBody Persona persona) {

    	personaDao.editar(persona);
    }
    
  
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "api/deletePersonaId", method = RequestMethod.POST)
    public void deletePersonaId(@RequestBody int id) {

    	personaDao.deletePersonaId(id);
    }
   
    
}
