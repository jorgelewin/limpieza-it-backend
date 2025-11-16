package com.digitalers.limpiezaIT.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Producto {

    Long id;
    String nombre;
    Double precio;
    String descripcion;
    String urlImagen;


}
