package com.digitalers.limpiezaIT.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Producto {

    Long id;
    String nombre;
    Double precio;
    String descripcion;
    String urlImagen;


}
