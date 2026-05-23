package com.libreria.steps;

import com.libreria.modelo.Producto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import static org.assertj.core.api.Assertions.*;

public class LibreriaSteps {

    private Producto producto;
    private Exception excepcionCapturada;
    private double precioFinalCalculado;

    @Given("que existe un catálogo de productos en la librería")
    public void queExisteUnCatalogoDeProductosEnLaLibreria() {
        // Background step - simplemente confirmamos que podemos crear productos
    }

    @Given("un producto {string} con precio base de {double} pesos")
    public void unProductoConPrecioBaseDePesos(String nombre, double precioBase) {
        producto = new Producto(nombre, precioBase);
    }

    @When("aplico un descuento del {double} por ciento")
    public void aplicoUnDescuentoDelPorCiento(double descuento) {
        producto.aplicarDescuento(descuento);
    }

    @When("intento aplicar un descuento del {double} por ciento")
    public void intentoAplicarUnDescuentoDelPorCiento(double descuento) {
        try {
            producto.aplicarDescuento(descuento);
        } catch (Exception e) {
            excepcionCapturada = e;
        }
    }

    @When("calculo el precio final con IVA")
    public void calculoElPrecioFinalConIVA() {
        precioFinalCalculado = producto.getPrecioFinal();
    }

    @Then("el precio con descuento debe ser {double} pesos")
    public void elPrecioConDescuentoDebeSerPesos(double precioEsperado) {
        assertThat(producto.getPrecioConDescuento())
                .isCloseTo(precioEsperado, within(0.01));
    }

    @Then("debe lanzar una excepción con el mensaje {string}")
    public void debeLanzarUnaExcepcionConElMensaje(String mensajeEsperado) {
        assertThat(excepcionCapturada)
                .isNotNull()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensajeEsperado);
    }

    @Then("el precio final debe ser {double} pesos")
    public void elPrecioFinalDebeSerPesos(double precioEsperado) {
        assertThat(precioFinalCalculado)
                .isCloseTo(precioEsperado, within(0.01));
    }

    @Then("el precio final debe ser positivo")
    public void elPrecioFinalDebeSerPositivo() {
        assertThat(precioFinalCalculado).isPositive();
    }

    @And("no se puede calcular el precio final")
    public void noSePuedeCalcularElPrecioFinal() {
        // Verificamos que efectivamente se lanzó la excepción y no se pudo aplicar el descuento
        assertThat(excepcionCapturada).isNotNull();
    }
}
