package com.libreria;

import com.libreria.modelo.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Tests de Descuento - Regla 2: Validación de Descuentos")
class DescuentoTest {

    private Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto("Cuaderno", 10000);
    }

    @Test
    @DisplayName("CP04: Aplicar descuento válido del 20%")
    void aplicarDescuentoValido() {
        assertThatCode(() -> producto.aplicarDescuento(20))
                .doesNotThrowAnyException();

        producto.aplicarDescuento(20);
        assertThat(producto.getPrecioConDescuento()).isEqualTo(8000);
    }

    @Test
    @DisplayName("CP05: Aplicar descuento del límite inferior (0%)")
    void aplicarDescuentoLimiteInferior() {
        assertThatCode(() -> producto.aplicarDescuento(0))
                .doesNotThrowAnyException();

        producto.aplicarDescuento(0);
        assertThat(producto.getPrecioConDescuento()).isEqualTo(10000);
    }

    @Test
    @DisplayName("CP06: Aplicar descuento del límite superior (40%)")
    void aplicarDescuentoLimiteSuperior() {
        assertThatCode(() -> producto.aplicarDescuento(40))
                .doesNotThrowAnyException();

        producto.aplicarDescuento(40);
        assertThat(producto.getPrecioConDescuento()).isEqualTo(6000);
    }

    @Test
    @DisplayName("CP07: Rechazar descuento mayor al límite permitido (50%)")
    void rechazarDescuentoMayorAlLimite() {
        assertThatThrownBy(() -> producto.aplicarDescuento(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("El descuento debe estar entre 0% y 40%");
    }

    @Test
    @DisplayName("VL: Rechazar descuento negativo (-10%)")
    void rechazarDescuentoNegativo() {
        assertThatThrownBy(() -> producto.aplicarDescuento(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("El descuento debe estar entre 0% y 40%");
    }

    @Test
    @DisplayName("VL: Aceptar descuento justo debajo del límite superior (39.99%)")
    void aceptarDescuentoDebajoDeLimiteSuperior() {
        assertThatCode(() -> producto.aplicarDescuento(39.99))
                .doesNotThrowAnyException();

        producto.aplicarDescuento(39.99);
        assertThat(producto.getPrecioConDescuento()).isEqualTo(6000.1, within(0.01));
    }

    @Test
    @DisplayName("VL: Rechazar descuento justo encima del límite superior (40.01%)")
    void rechazarDescuentoEncimaDeLimiteSuperior() {
        assertThatThrownBy(() -> producto.aplicarDescuento(40.01))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("El descuento debe estar entre 0% y 40%");
    }
}
