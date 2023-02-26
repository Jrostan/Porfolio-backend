
package com.porfolio.porfolio.yo.programo.controller;

import com.porfolio.porfolio.yo.programo.Dto.dtoTrabajosPorfolio;
import com.porfolio.porfolio.yo.programo.entity.TrabajosPorfolio;
import com.porfolio.porfolio.yo.programo.security.controller.Mensaje;
import com.porfolio.porfolio.yo.programo.service.TrabajosPorfolioServ;
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
@RequestMapping("/tp")
@CrossOrigin(origins = {"http://localhost:4200", "https://j-rostan2.web.app"})
public class TPController {
    @Autowired
    TrabajosPorfolioServ tpServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<TrabajosPorfolio>> list() {
        List<TrabajosPorfolio> lisy = tpServ.List();
        return new ResponseEntity(lisy, HttpStatus.OK);
    }
            
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> create (@RequestBody dtoTrabajosPorfolio dtoTP){
        if(StringUtils.isBlank(dtoTP.getProyecto())){
            return new ResponseEntity(new Mensaje("El proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(tpServ.existByProyecto(dtoTP.getProyecto())){
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        TrabajosPorfolio tpPor = new TrabajosPorfolio(dtoTP.getProyecto(), dtoTP.getDescripcion(), dtoTP.getUrlImagen(), dtoTP.getLink());
        tpServ.save(tpPor);
        return new ResponseEntity(new Mensaje("Proyecto cargado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTrabajosPorfolio dtoTP){
        if(!tpServ.existsById(id)){
             return new ResponseEntity(new Mensaje("este ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(tpServ.existByProyecto(dtoTP.getProyecto()) && tpServ.getByProyecto(dtoTP.getProyecto()).get().getId() != id){
             return new ResponseEntity(new Mensaje("este proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoTP.getProyecto())){
             return new ResponseEntity(new Mensaje("El proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        TrabajosPorfolio tp = tpServ.getOne(id).get();
        tp.setProyecto(dtoTP.getProyecto());
        tp.setDescripcion(dtoTP.getDescripcion());
        tp.setUrlImagen(dtoTP.getUrlImagen());
        tp.setLink(dtoTP.getLink());
        tpServ.save(tp);
        return new ResponseEntity(new Mensaje("Trabajo actualizado correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!tpServ.existsById(id)){
            return new ResponseEntity(new Mensaje("este ID no existe"), HttpStatus.BAD_REQUEST);
        }
        tpServ.delete(id);
        return new ResponseEntity(new Mensaje("trabajo borrado"), HttpStatus.OK);
    }
    
    
}
