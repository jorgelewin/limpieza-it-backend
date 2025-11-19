package com.digitalers.limpiezaIT.controllers;

import com.digitalers.limpiezaIT.models.Producto;
import com.digitalers.limpiezaIT.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(@Autowired ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findBy(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(productoService.findBy(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    ResponseEntity<Producto> create(@RequestBody Producto producto) {

        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {

        try {
            return new ResponseEntity<>(productoService.updateBy(id, producto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {

        try {
            productoService.deleteBy(id);
            return ResponseEntity.ok("Producto eliminado correctamente.");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}