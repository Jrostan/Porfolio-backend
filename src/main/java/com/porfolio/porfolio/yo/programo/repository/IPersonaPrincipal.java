package com.porfolio.porfolio.yo.programo.repository;

import com.porfolio.porfolio.yo.programo.entity.PersonaPrincipal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaPrincipal extends JpaRepository<PersonaPrincipal, Integer>{
    
    public Optional<PersonaPrincipal> findByNombre (String nombre);
    public boolean existsByNombre (String Nombre);
}
