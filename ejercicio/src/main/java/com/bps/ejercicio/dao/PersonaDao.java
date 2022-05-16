package com.bps.ejercicio.dao;

import java.util.List;

import com.bps.ejercicio.models.Persona;

public interface PersonaDao {

    List<Persona> getPersonas();

   void registrar(Persona producto);

   void editar(Persona producto);
   
   Persona obtenerPersonaPorID(Integer id);
   
   void deletePersonaId(Integer id);
   
  

}
