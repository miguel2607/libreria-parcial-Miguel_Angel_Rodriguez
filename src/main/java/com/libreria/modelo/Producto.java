package com.libreria.modelo;

public class Producto {
    private static final double DESCUENTO_MINIMO = 0;
    private static final double DESCUENTO_MAXIMO = 40;
    private static final double PORCENTAJE_DIVISOR = 100.0;
    private static final double IVA = 19.0;

    private final String nombre;
    private final double precioBase;
    private double descuento;

    public Producto(String nombre, double precioBase) {
        validarNombre(nombre);
        validarPrecioBase(precioBase);
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.descuento = DESCUENTO_MINIMO;
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

    private void validarDescuento(double descuento) {
        if (descuento < DESCUENTO_MINIMO || descuento > DESCUENTO_MAXIMO) {
            throw new IllegalArgumentException("El descuento debe estar entre 0% y 40%");
        }
    }

    public void aplicarDescuento(double descuento) {
        validarDescuento(descuento);
        this.descuento = descuento;
    }

    public double getPrecioConDescuento() {
        return calcularPrecioConDescuento(precioBase, descuento);
    }

    private double calcularPrecioConDescuento(double precio, double descuentoPorcentaje) {
        double montoDescuento = precio * descuentoPorcentaje / PORCENTAJE_DIVISOR;
        return precio - montoDescuento;
    }

    public double getPrecioFinal() {
        double precioConDescuento = getPrecioConDescuento();
        return aplicarIVA(precioConDescuento);
    }

    private double aplicarIVA(double precio) {
        return precio * (1 + IVA / PORCENTAJE_DIVISOR);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getDescuento() {
        return descuento;
    }
}
