package com.digitalers.limpiezaIT.repositories;

import com.digitalers.limpiezaIT.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {


}
