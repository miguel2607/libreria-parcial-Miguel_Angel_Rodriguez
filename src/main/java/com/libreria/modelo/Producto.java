package com.libreria.modelo;

public class Producto {
    private String nombre;
    private double precioBase;

    public Producto(String nombre, double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor que cero");
        }
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
