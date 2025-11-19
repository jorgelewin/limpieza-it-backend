package com.digitalers.limpiezaIT.services;

import com.digitalers.limpiezaIT.models.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();

    Producto findBy(Long id) throws Exception;

    Producto save(Producto producto);

    Producto updateBy(Long id, Producto producto) throws Exception;

    void deleteBy(Long id) throws Exception;
}
