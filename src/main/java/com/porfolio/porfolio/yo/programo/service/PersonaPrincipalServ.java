package com.porfolio.porfolio.yo.programo.service;

import com.porfolio.porfolio.yo.programo.entity.PersonaPrincipal;
import com.porfolio.porfolio.yo.programo.repository.IPersonaPrincipal;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaPrincipalServ {
    
    @Autowired
    IPersonaPrincipal iPersonaPrincipal;

    public List<PersonaPrincipal> List(){
        return iPersonaPrincipal.findAll();
    };
    
    public Optional<PersonaPrincipal> getOne (int id){
        return iPersonaPrincipal.findById(id);
    }
    
    public Optional<PersonaPrincipal> getByPersona(String nombre){
        return iPersonaPrincipal.findByNombre(nombre);
    }
    
    public void save (PersonaPrincipal per){
        iPersonaPrincipal.save(per);
    };
    
    public void delete(int id){
        iPersonaPrincipal.deleteById(id);
    };
    
    public boolean existById (int id){
        return iPersonaPrincipal.existsById(id);
    };
    
    public boolean existByPersona (String persona){
        return iPersonaPrincipal.existsByNombre(persona);
    };
    
}
