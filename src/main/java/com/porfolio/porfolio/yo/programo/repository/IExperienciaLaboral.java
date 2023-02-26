package com.porfolio.porfolio.yo.programo.repository;

import com.porfolio.porfolio.yo.programo.entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboral extends JpaRepository<ExperienciaLaboral, Integer>{
    
    public Optional<ExperienciaLaboral> findByPuesto (String puesto);
    
    public boolean existsByPuesto (String puesto);
    
}
