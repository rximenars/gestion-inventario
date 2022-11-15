package co.edu.unisabana.gestioninventariomicroservicio.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.unisabana.gestioninventariomicroservicio.entity.InventarioEntity;
import co.edu.unisabana.gestioninventariomicroservicio.repository.InventarioRepository;
import co.edu.unisabana.gestioninventariomicroservicio.controller.InventarioController;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioControllerTest {
    InventarioController inventarioController;
    @Autowired
    private InventarioRepository inventarioRepository;
    private TestRestTemplate restTemplate;

    private static final String PATH_LOOKFOR = "/api/inventario";

    @Test
    public void Given_codigo_When_inventarioDisponible_Then_return_True (){
        InventarioEntity inventarioEntity = new InventarioEntity();
        inventarioRepository.save(inventarioEntity);
        //ResponseEntity<Boolean> result = restTemplate.postForEntity(PATH_LOOKFOR,codigo, Boolean.class);
        assertTrue(inventarioController.inventarioDisponible(inventarioEntity.getCodigo()));
    }

    @Test
    public void Given_codigo_When_inventarioDisponible_Then_return_RuntimeException (){
        String codigo = "0000";
        //ResponseEntity<Boolean> result = restTemplate.postForEntity(PATH_LOOKFOR,codigo, Boolean.class);
        assertThrows(RuntimeException.class, () -> {
            inventarioController.inventarioDisponible(codigo);
        });
    }
}
