package com.porfolio.porfolio.yo.programo.service;

import com.porfolio.porfolio.yo.programo.entity.TrabajosPorfolio;
import com.porfolio.porfolio.yo.programo.repository.ITrabajosPorfolio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TrabajosPorfolioServ {
    
    @Autowired
    ITrabajosPorfolio iTrabajosPorfolio;
    
    public List<TrabajosPorfolio> List(){
        return iTrabajosPorfolio.findAll();
    };
    
    public Optional<TrabajosPorfolio> getOne(int id){
        return iTrabajosPorfolio.findById(id);
    };
    
    public Optional<TrabajosPorfolio> getByProyecto(String proyect){
        return iTrabajosPorfolio.findByProyecto(proyect);
    };
    
    public void save(TrabajosPorfolio trab){
        iTrabajosPorfolio.save(trab);
    };
    
    public void delete(int id){
        iTrabajosPorfolio.deleteById(id);
    };
    
    public boolean existsById(int id){
        return iTrabajosPorfolio.existsById(id);
    };
    
    public boolean existByProyecto(String proyect){
        return iTrabajosPorfolio.existsByProyecto(proyect);
    };
}
