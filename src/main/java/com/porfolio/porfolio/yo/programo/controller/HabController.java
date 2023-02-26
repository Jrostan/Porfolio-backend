package com.porfolio.porfolio.yo.programo.controller;

import com.porfolio.porfolio.yo.programo.Dto.dtoHabilidadesDigitales;
import com.porfolio.porfolio.yo.programo.entity.HabilidadesDigitales;
import com.porfolio.porfolio.yo.programo.security.controller.Mensaje;
import com.porfolio.porfolio.yo.programo.service.HabilidadesDigitalesServ;
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
@RequestMapping("/hab")
@CrossOrigin(origins = {"http://localhost:4200", "https://j-rostan2.web.app"})
public class HabController {

    @Autowired
    HabilidadesDigitalesServ habServ;

    //Devuelve la lista de completa de habilidades digitales
    @GetMapping("/lista")
    public ResponseEntity<List<HabilidadesDigitales>> list() {
        List<HabilidadesDigitales> list = habServ.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> creat(@RequestBody dtoHabilidadesDigitales dtoHab) {
        if (StringUtils.isBlank(dtoHab.getTecnologia())) {
            return new ResponseEntity(new Mensaje("La Tecnologia es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (habServ.existByTecnologia(dtoHab.getTecnologia())) {
            return new ResponseEntity(new Mensaje("Esta Tecnologia ya existe"), HttpStatus.BAD_REQUEST);
        }
        HabilidadesDigitales hab = new HabilidadesDigitales(
                dtoHab.getTecnologia(),
                dtoHab.getPorcentaje(),
                dtoHab.getColorBarraFuerte(),
                dtoHab.getColorBarraDebil()
        );
        habServ.save(hab);
        return new ResponseEntity(new Mensaje("Habilidad cargada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidadesDigitales dtoHab){
        if(!habServ.existsById(id)){
            return new ResponseEntity(new Mensaje("este ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(habServ.existByTecnologia(dtoHab.getTecnologia()) && habServ.getByTecnologia(dtoHab.getTecnologia()).get().getId() != id){
            return new ResponseEntity(new Mensaje("esta habilidad no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoHab.getTecnologia())){
            return new ResponseEntity(new Mensaje("La tecnologia es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        HabilidadesDigitales hab = habServ.getOne(id).get();
        hab.setTecnologia(dtoHab.getTecnologia());
        hab.setPorcentaje(dtoHab.getPorcentaje());
        hab.setColorBarraFuerte(dtoHab.getColorBarraFuerte());
        hab.setColorBarraDebil(dtoHab.getColorBarraDebil());
        habServ.save(hab);
        return new ResponseEntity(new Mensaje("Habilidad actualizada correctamente"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!habServ.existsById(id)){
            return new ResponseEntity(new Mensaje("este ID no existe"), HttpStatus.BAD_REQUEST);
        }
        habServ.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad borrada"), HttpStatus.OK);
    }
}
