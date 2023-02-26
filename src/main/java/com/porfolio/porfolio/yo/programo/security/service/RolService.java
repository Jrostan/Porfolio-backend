package com.porfolio.porfolio.yo.programo.security.service;

import com.porfolio.porfolio.yo.programo.security.entity.Rol;
import com.porfolio.porfolio.yo.programo.security.enums.RolNombre;
import com.porfolio.porfolio.yo.programo.security.repository.iRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getbyRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
