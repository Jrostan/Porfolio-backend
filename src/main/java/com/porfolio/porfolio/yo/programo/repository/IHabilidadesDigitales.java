package com.porfolio.porfolio.yo.programo.repository;

import com.porfolio.porfolio.yo.programo.entity.HabilidadesDigitales;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadesDigitales extends JpaRepository<HabilidadesDigitales, Integer>{

    public Optional<HabilidadesDigitales> findByTecnologia (String tecnologia);
    public boolean existsByTecnologia (String tecnologia);
            
}
