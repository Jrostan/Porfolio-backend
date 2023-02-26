 /*Controller de capacitaciones*/
package com.porfolio.porfolio.yo.programo.controller;

import com.porfolio.porfolio.yo.programo.Dto.dtoCapacitaciones;
import com.porfolio.porfolio.yo.programo.entity.Capacitaciones;
import com.porfolio.porfolio.yo.programo.security.controller.Mensaje;
import com.porfolio.porfolio.yo.programo.service.CapacitacionesServ;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cap")
@CrossOrigin(origins = {"http://localhost:4200", "https://j-rostan2.web.app"})
public class CapController {
    @Autowired
    CapacitacionesServ capServ;
    
    //Devuelve la lista de completa de capacitaciones
    @GetMapping("/lista")
    public ResponseEntity<List<Capacitaciones>> list() {
        List<Capacitaciones> list = capServ.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Agrega una nueva capacitacion
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> creat(@RequestBody dtoCapacitaciones dtocap){
        //verifica qie el Titulo no este en blanco
        if(StringUtils.isBlank(dtocap.getTitulo())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //verifica los titulos duplicados
        if(capServ.existsByTitulo(dtocap.getTitulo())){
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        // crea el nuevo objeto:
        Capacitaciones cap = new Capacitaciones(dtocap.getTitulo(), dtocap.getDescripcion(), dtocap.getUrlLogo(), dtocap.getFormador());
        //guarda el nuevo objeto:
        capServ.save(cap);
        // Responde y confirma al Front la creacion correcta:
        return new ResponseEntity(new Mensaje("Capacitacion cargada correctamente"), HttpStatus.OK);
    }
    
    //Actualiza el objeto en cuestion
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoCapacitaciones dtocap){
        // valida la existencia del id
        if(!capServ.existsById(id)){
            return new ResponseEntity(new Mensaje("este ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // verifica la existencia del titulo para ese ID o compara lo nuevo con lo viejo
        if(capServ.existsByTitulo(dtocap.getTitulo()) && capServ.getByTitulo(dtocap.getTitulo()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esta capacitacion no existe"), HttpStatus.BAD_REQUEST);
        }
        //Valida Nombre en blanco
        if(StringUtils.isBlank(dtocap.getTitulo())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //genera un nuevo objeto para posteriormente actualizar
        Capacitaciones cap = capServ.getOne(id).get();
        //setea el nombre al nuevo objeto con la informacion del DTO
        cap.setTitulo(dtocap.getTitulo());
        cap.setDescripcion(dtocap.getDescripcion());
        cap.setUrlLogo(dtocap.getUrlLogo());
        cap.setFormador(dtocap.getFormador());
        //graba el nuevo objeto (el actualizado) en la DB
        capServ.save(cap);
        // Responde y confirma al Front la correcta actualizacion:
        return new ResponseEntity(new Mensaje("Capacitacion actualizada correctamente"), HttpStatus.OK);
    }
    
    //borrar un objeto
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        // valida la existencia del id
        if(!capServ.existsById(id)){
            return new ResponseEntity(new Mensaje("este ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //borra el objeto de la DB
        capServ.delete(id);
        // Responde y confirma al Front la correcta eliminacion:
        return new ResponseEntity(new Mensaje("Capacitacion borrada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Capacitaciones> getById(@PathVariable("id") int id){
        if(!capServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Capacitaciones experiencia = capServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
