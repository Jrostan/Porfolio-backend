/*Interface de Capacitaciones*/
package com.porfolio.porfolio.yo.programo.repository;

import com.porfolio.porfolio.yo.programo.entity.Capacitaciones;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICapacitaciones extends JpaRepository<Capacitaciones, Integer> {
    
    public Optional<Capacitaciones> findByTitulo (String titulo);
    public boolean existsByTitulo (String titulo);
}
