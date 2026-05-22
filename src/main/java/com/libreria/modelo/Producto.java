package com.libreria.modelo;

public class Producto {
    private final String nombre;
    private final double precioBase;

    public Producto(String nombre, double precioBase) {
        validarNombre(nombre);
        validarPrecioBase(precioBase);
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
    }

    private void validarPrecioBase(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor que cero");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
