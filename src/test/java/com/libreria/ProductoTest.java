package com.libreria;

import com.libreria.modelo.Producto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Tests de Producto - Regla 1: Validación de Precio Base")
class ProductoTest {

    @Test
    @DisplayName("CP01: Crear producto con precio válido mayor que cero")
    void crearProductoConPrecioValido() {
        // Given - Arrange
        String nombre = "Cuaderno";
        double precio = 10000;

        // When - Act & Assert
        assertThatCode(() -> new Producto(nombre, precio))
                .doesNotThrowAnyException();

        Producto producto = new Producto(nombre, precio);
        assertThat(producto.getNombre()).isEqualTo(nombre);
        assertThat(producto.getPrecioBase()).isEqualTo(precio);
    }

    @Test
    @DisplayName("CP02: Rechazar producto con precio igual a cero")
    void rechazarProductoConPrecioCero() {
        // Given - Arrange
        String nombre = "Lápiz";
        double precio = 0;

        // When & Then - Act & Assert
        assertThatThrownBy(() -> new Producto(nombre, precio))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("El precio base debe ser mayor que cero");
    }

    @Test
    @DisplayName("CP03: Rechazar producto con precio negativo")
    void rechazarProductoConPrecioNegativo() {
        // Given - Arrange
        String nombre = "Borrador";
        double precio = -5000;

        // When & Then - Act & Assert
        assertThatThrownBy(() -> new Producto(nombre, precio))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("El precio base debe ser mayor que cero");
    }
}
