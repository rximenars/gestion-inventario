package co.edu.unisabana.gestioninventariomicroservicio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unisabana.gestioninventariomicroservicio.entity.InventarioEntity;

public interface InventarioRepository extends JpaRepository<InventarioEntity, Long>
{
    Optional<InventarioEntity> findByCode(String codigo);
}
