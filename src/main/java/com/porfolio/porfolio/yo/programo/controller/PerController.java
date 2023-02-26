package com.porfolio.porfolio.yo.programo.controller;

import com.porfolio.porfolio.yo.programo.Dto.dtoPersonaPrincipal;
import com.porfolio.porfolio.yo.programo.entity.PersonaPrincipal;
import com.porfolio.porfolio.yo.programo.security.controller.Mensaje;
import com.porfolio.porfolio.yo.programo.service.PersonaPrincipalServ;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/per")
@CrossOrigin(origins = {"http://localhost:4200", "https://j-rostan2.web.app"})
public class PerController {
    @Autowired
    PersonaPrincipalServ perServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<PersonaPrincipal>> lista() {
        List<PersonaPrincipal> list = perServ.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crear(@RequestBody dtoPersonaPrincipal dtoPer) {
        if(StringUtils.isBlank(dtoPer.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        PersonaPrincipal per = new PersonaPrincipal(dtoPer.getNombre(), dtoPer.getDescripcion(), dtoPer.getUrlFoto(), dtoPer.getTitulo(), dtoPer.getOriundo());
        perServ.save(per);
        return new ResponseEntity(new Mensaje("Persona cargada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersonaPrincipal dtoPer) {
        if(!perServ.existById(id)){
            return new ResponseEntity(new Mensaje("este ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(perServ.existByPersona(dtoPer.getNombre()) && perServ.getByPersona(dtoPer.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esta persona no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPer.getNombre())){
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        PersonaPrincipal per = perServ.getOne(id).get();
        per.setNombre(dtoPer.getNombre());
        per.setDescripcion(dtoPer.getDescripcion());
        per.setUrlFoto(dtoPer.getUrlFoto());
        per.setTitulo(dtoPer.getTitulo());
        per.setOriundo(dtoPer.getOriundo());
        perServ.save(per);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
