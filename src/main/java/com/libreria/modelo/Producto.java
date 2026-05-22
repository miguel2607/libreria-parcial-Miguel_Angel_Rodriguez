package com.libreria.modelo;

public class Producto {
    private final String nombre;
    private final double precioBase;
    private double descuento;

    public Producto(String nombre, double precioBase) {
        validarNombre(nombre);
        validarPrecioBase(precioBase);
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.descuento = 0;
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

    public void aplicarDescuento(double descuento) {
        if (descuento < 0 || descuento > 40) {
            throw new IllegalArgumentException("El descuento debe estar entre 0% y 40%");
        }
        this.descuento = descuento;
    }

    public double getPrecioConDescuento() {
        return precioBase - (precioBase * descuento / 100);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
