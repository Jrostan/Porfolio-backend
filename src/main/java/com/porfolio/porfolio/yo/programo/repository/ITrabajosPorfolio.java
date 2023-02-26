package com.porfolio.porfolio.yo.programo.repository;

import com.porfolio.porfolio.yo.programo.entity.TrabajosPorfolio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajosPorfolio extends JpaRepository<TrabajosPorfolio, Integer>{

    public Optional<TrabajosPorfolio> findByProyecto (String proyecto);
    public boolean existsByProyecto (String proyecto);
    
}
