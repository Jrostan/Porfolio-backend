package com.porfolio.porfolio.yo.programo.security.repository;

import com.porfolio.porfolio.yo.programo.security.entity.Rol;
import com.porfolio.porfolio.yo.programo.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
