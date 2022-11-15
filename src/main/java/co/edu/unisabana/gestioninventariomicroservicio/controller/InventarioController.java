package co.edu.unisabana.gestioninventariomicroservicio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisabana.gestioninventariomicroservicio.entity.InventarioEntity;
import co.edu.unisabana.gestioninventariomicroservicio.repository.InventarioRepository;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController 
{
    @Autowired
    private InventarioRepository inventarioRepository;

    public boolean inventarioDisponible(@PathVariable String codigo)
    {
        Optional<InventarioEntity> inventario = inventarioRepository.findByCode(codigo);

        inventario.orElseThrow(() -> new RuntimeException("No hay inventario disponible para ese producto" +codigo));

        return inventario.get().getCantidad() > 0;
    }

}
