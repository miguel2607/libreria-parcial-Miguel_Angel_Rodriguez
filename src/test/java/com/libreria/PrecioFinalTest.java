package com.libreria;

import com.libreria.modelo.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Tests de Precio Final - Regla 3: Cálculo con IVA")
class PrecioFinalTest {

    private Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto("Cuaderno", 10000);
    }

    @Test
    @DisplayName("CP08: Calcular precio final sin descuento (IVA 19%)")
    void calcularPrecioFinalSinDescuento() {
        producto.aplicarDescuento(0);

        double precioFinal = producto.getPrecioFinal();

        assertThat(precioFinal).isEqualTo(11900);
    }

    @Test
    @DisplayName("CP09: Calcular precio final con descuento máximo (40%) y aplicar IVA 19%")
    void calcularPrecioFinalConDescuentoMaximo() {
        producto.aplicarDescuento(40);

        double precioFinal = producto.getPrecioFinal();

        assertThat(precioFinal).isEqualTo(7140);
    }

    @Test
    @DisplayName("Calcular precio final con descuento del 20% y aplicar IVA 19%")
    void calcularPrecioFinalConDescuento() {
        producto.aplicarDescuento(20);

        double precioFinal = producto.getPrecioFinal();

        assertThat(precioFinal).isEqualTo(9520);
    }

    @Test
    @DisplayName("Verificar que el precio final nunca es negativo")
    void verificarPrecioFinalNuncaNegativo() {
        Producto productoMinimo = new Producto("Item", 0.01);
        productoMinimo.aplicarDescuento(40);

        double precioFinal = productoMinimo.getPrecioFinal();

        assertThat(precioFinal).isPositive();
    }

    @Test
    @DisplayName("Calcular precio final para producto de precio alto")
    void calcularPrecioFinalProductoPrecioAlto() {
        Producto productoAlto = new Producto("Laptop", 1000000);
        productoAlto.aplicarDescuento(15);

        double precioFinal = productoAlto.getPrecioFinal();

        assertThat(precioFinal).isEqualTo(1011500);
    }
}
