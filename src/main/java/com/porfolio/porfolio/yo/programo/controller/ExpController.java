package com.porfolio.porfolio.yo.programo.controller;

import com.porfolio.porfolio.yo.programo.Dto.dtoExperienciaLaboral;
import com.porfolio.porfolio.yo.programo.entity.ExperienciaLaboral;
import com.porfolio.porfolio.yo.programo.security.controller.Mensaje;
import com.porfolio.porfolio.yo.programo.service.ExperienciaServ;
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
@RequestMapping("/exp")
@CrossOrigin(origins = {"http://localhost:4200", "https://j-rostan2.web.app"})
public class ExpController {

    @Autowired
    ExperienciaServ expServ;

    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list() {
        List<ExperienciaLaboral> list = expServ.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> create(@RequestBody dtoExperienciaLaboral dtoExp) {
        //Verifica que no este en blanco
        if (StringUtils.isBlank(dtoExp.getDescPuesto())) {
            return new ResponseEntity(new Mensaje("El Puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //Verifica Duplicados
        if (expServ.ExistByPuesto(dtoExp.getPuesto())) {
            return new ResponseEntity(new Mensaje("Ese puesto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //Crea nuevo objeto
        ExperienciaLaboral expLab = new ExperienciaLaboral(
                dtoExp.getPuesto(),
                dtoExp.getFechainicio(),
                dtoExp.getFechaFinal(),
                dtoExp.getDescPuesto(),
                dtoExp.getEmpresa(),
                dtoExp.getUrlLogo());
        //Guarda nuevo objeto
        expServ.save(expLab);
        //Responde y confirma
        return new ResponseEntity(new Mensaje("Experiencia cargada correctamente"), HttpStatus.OK);
    }

    //Actualiza Objeto
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<ExperienciaLaboral> update(@PathVariable("id") int id, @RequestBody dtoExperienciaLaboral dtoExp) {
        // Valida ID
        if (!expServ.existById(id)) {
            return new ResponseEntity(new Mensaje("Este Id no existe"), HttpStatus.BAD_REQUEST);
        };
        // Verifica ID y existencia de la experiencia
        if (expServ.ExistByPuesto(dtoExp.getPuesto()) && expServ.getByPuesto(dtoExp.getPuesto()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Este Puesto ya existe"), HttpStatus.BAD_REQUEST);
        };
        //valida puesto en blanco
        if (StringUtils.isBlank(dtoExp.getPuesto())) {
            return new ResponseEntity(new Mensaje("El Puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        };

        //genera un nuevo objeto para posteriormente actualizar
        ExperienciaLaboral exp = expServ.getOne(id).get();
        //setea el nombre al nuevo objeto con la informacion del DTO
        exp.setDescPuesto(dtoExp.getDescPuesto());
        exp.setEmpresa(dtoExp.getEmpresa());
        exp.setFechaFinal(dtoExp.getFechaFinal());
        exp.setFechainicio(dtoExp.getFechainicio());
        exp.setPuesto(dtoExp.getPuesto());
        exp.setUrlLogo(dtoExp.getUrlLogo());
        //graba el nuevo objeto (el actualizado) en la DB
        expServ.save(exp);
        // Responde y confirma al Front la correcta actualizacion:
        return new ResponseEntity(new Mensaje("Experiencia laboreal actualizada correctamente"), HttpStatus.OK);
    }

    //Borrar un  experienca laboral
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Valida existencia ID
        if (!expServ.existById(id)) {
            return new ResponseEntity(new Mensaje("Experiencia / ID inexistente"), HttpStatus.BAD_REQUEST);
        };
        //Borra objeto
        expServ.delete(id);
        // confirma
        return new ResponseEntity(new Mensaje("Experiencia Borrada"), HttpStatus.OK);
    }

}
