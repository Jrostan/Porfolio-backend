package com.porfolio.porfolio.yo.programo.service;

import com.porfolio.porfolio.yo.programo.entity.ExperienciaLaboral;
import com.porfolio.porfolio.yo.programo.repository.IExperienciaLaboral;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaServ {
    
    @Autowired
    IExperienciaLaboral iExperienciaLaboral;
    
    public List<ExperienciaLaboral> List() {
        return iExperienciaLaboral.findAll();
    };
    
    public Optional<ExperienciaLaboral> getOne(int id){
        return iExperienciaLaboral.findById(id);
    };
    
    public Optional<ExperienciaLaboral> getByPuesto(String puesto){
        return iExperienciaLaboral.findByPuesto(puesto);
    };
    
    public void save(ExperienciaLaboral exp){
        iExperienciaLaboral.save(exp);
    };
    
    public void delete(int id){
        iExperienciaLaboral.deleteById(id);
    };
    
    public boolean existById(int id){
        return iExperienciaLaboral.existsById(id);
    };
    
    public boolean ExistByPuesto(String puesto){
        return iExperienciaLaboral.existsByPuesto(puesto);
    };
}
