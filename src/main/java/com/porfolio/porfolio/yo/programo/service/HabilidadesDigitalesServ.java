package com.porfolio.porfolio.yo.programo.service;

import com.porfolio.porfolio.yo.programo.entity.HabilidadesDigitales;
import com.porfolio.porfolio.yo.programo.repository.IHabilidadesDigitales;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadesDigitalesServ {
    
    @Autowired
    IHabilidadesDigitales iHabilidadesDigitales;
    
    public List<HabilidadesDigitales> List(){
        return iHabilidadesDigitales.findAll();
    };
    
    public Optional<HabilidadesDigitales> getOne(int id){
        return iHabilidadesDigitales.findById(id);
    };
    
    public Optional<HabilidadesDigitales> getByTecnologia(String tecno){
        return iHabilidadesDigitales.findByTecnologia(tecno);
    };
    
    public void save(HabilidadesDigitales hab){
        iHabilidadesDigitales.save(hab);
    };
    
    public void delete(int id){
        iHabilidadesDigitales.deleteById(id);
    };
    
    public boolean existsById(int id){
        return iHabilidadesDigitales.existsById(id);
    };
    
    public boolean existByTecnologia(String tecno){
        return iHabilidadesDigitales.existsByTecnologia(tecno);
    };
}
