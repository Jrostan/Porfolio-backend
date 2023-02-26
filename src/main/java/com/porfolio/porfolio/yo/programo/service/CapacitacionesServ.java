/*Service de capacitaciones*/
package com.porfolio.porfolio.yo.programo.service;

import com.porfolio.porfolio.yo.programo.entity.Capacitaciones;
import com.porfolio.porfolio.yo.programo.repository.ICapacitaciones;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CapacitacionesServ {
    
    @Autowired
    ICapacitaciones iCapacitaciones;
    
    //metodo que devuelve una lista con todas la capacitaciones que encuenre
    public List<Capacitaciones> List() {
        return iCapacitaciones.findAll();
    }
    
    //metodo que busca una cap por id
    public Optional<Capacitaciones> getOne(int id) {
        return iCapacitaciones.findById(id);
    }
    
    //metodo que busca cap por titulo
    public Optional<Capacitaciones> getByTitulo(String titulo){
        return iCapacitaciones.findByTitulo(titulo);
    }
    
    public void save(Capacitaciones cap){
        iCapacitaciones.save(cap);
    }
    
    public void delete(int id){
        iCapacitaciones.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iCapacitaciones.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return iCapacitaciones.existsByTitulo(titulo);
    }
}
