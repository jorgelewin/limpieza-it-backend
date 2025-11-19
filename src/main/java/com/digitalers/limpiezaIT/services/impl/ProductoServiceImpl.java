package com.digitalers.limpiezaIT.services.impl;

import com.digitalers.limpiezaIT.exceptions.ProductoNotFoundException;
import com.digitalers.limpiezaIT.models.Producto;
import com.digitalers.limpiezaIT.repositories.ProductoRepository;
import com.digitalers.limpiezaIT.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(@Autowired ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findBy(Long id) throws Exception {

        Optional<Producto> producto = productoRepository.findById(id);

        if (producto.isEmpty()) {

            throw new ProductoNotFoundException("Producto no encontrado");
        }

        return producto.get();
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateBy(Long id, Producto producto) throws Exception {
        Optional<Producto> productoFind = productoRepository.findById(id);

        if (productoFind.isEmpty()) {

            throw new ProductoNotFoundException("No se pudo Actualizar. Producto no encontrado");
        }

        Producto productoUpdate = productoFind.get();
        productoUpdate.setNombre(producto.getNombre());
        productoUpdate.setPrecio(producto.getPrecio());
        productoUpdate.setDescripcion(producto.getDescripcion());
        productoUpdate.setUrlImagen(producto.getUrlImagen());

        return productoRepository.save(productoUpdate);
    }

    @Override
    public void deleteBy(Long id) throws Exception {
        Optional<Producto> producto = productoRepository.findById(id);

        if (producto.isEmpty()) {
            throw new ProductoNotFoundException("No se pudo Eliminar. Producto no encontrado");
        }

        productoRepository.deleteById(id);
    }
}
