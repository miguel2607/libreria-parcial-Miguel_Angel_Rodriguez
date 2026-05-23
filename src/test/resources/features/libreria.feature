Feature: Gestión de descuentos y cálculo de precio final en librería
  Como gerente de la librería
  Quiero aplicar descuentos controlados a los productos y calcular el precio final con IVA
  Para ofrecer promociones a mis clientes manteniendo la rentabilidad del negocio

  Background:
    Given que existe un catálogo de productos en la librería

  @regla2 @descuento @positivo
  Scenario: Aplicar descuento válido del 20% a un producto
    Given un producto "Cuaderno" con precio base de 10000 pesos
    When aplico un descuento del 20 por ciento
    Then el precio con descuento debe ser 8000 pesos

  @regla2 @descuento @positivo @limites
  Scenario Outline: Aplicar diferentes descuentos válidos al producto
    Given un producto "<producto>" con precio base de <precioBase> pesos
    When aplico un descuento del <descuento> por ciento
    Then el precio con descuento debe ser <precioEsperado> pesos

    Examples:
      | producto  | precioBase | descuento | precioEsperado |
      | Cuaderno  | 10000      | 0         | 10000          |
      | Lápiz     | 10000      | 20        | 8000           |
      | Borrador  | 10000      | 40        | 6000           |
      | Marcador  | 10000      | 39.99     | 6001           |
      | Regla     | 5000       | 25        | 3750           |

  @regla2 @descuento @negativo @error
  Scenario: Rechazar descuento mayor al límite permitido
    Given un producto "Cuaderno" con precio base de 10000 pesos
    When intento aplicar un descuento del 50 por ciento
    Then debe lanzar una excepción con el mensaje "El descuento debe estar entre 0% y 40%"

  @regla2 @descuento @negativo @error
  Scenario: Rechazar descuento negativo
    Given un producto "Libro" con precio base de 25000 pesos
    When intento aplicar un descuento del -10 por ciento
    Then debe lanzar una excepción con el mensaje "El descuento debe estar entre 0% y 40%"

  @regla2 @descuento @negativo @error
  Scenario: Rechazar descuento justo encima del límite superior
    Given un producto "Revista" con precio base de 15000 pesos
    When intento aplicar un descuento del 40.01 por ciento
    Then debe lanzar una excepción con el mensaje "El descuento debe estar entre 0% y 40%"

  @regla3 @precioFinal @positivo
  Scenario: Calcular precio final sin descuento con IVA del 19%
    Given un producto "Cuaderno" con precio base de 10000 pesos
    And aplico un descuento del 0 por ciento
    When calculo el precio final con IVA
    Then el precio final debe ser 11900 pesos

  @regla3 @precioFinal @positivo
  Scenario Outline: Calcular precio final con diferentes descuentos y aplicar IVA
    Given un producto "<producto>" con precio base de <precioBase> pesos
    And aplico un descuento del <descuento> por ciento
    When calculo el precio final con IVA
    Then el precio final debe ser <precioFinal> pesos

    Examples:
      | producto | precioBase | descuento | precioFinal |
      | Cuaderno | 10000      | 0         | 11900       |
      | Lápiz    | 10000      | 20        | 9520        |
      | Borrador | 10000      | 40        | 7140        |
      | Laptop   | 1000000    | 15        | 1011500     |
      | Mouse    | 50000      | 10        | 53550       |

  @regla3 @precioFinal @positivo
  Scenario: Verificar que el precio final nunca es negativo
    Given un producto "Item Mínimo" con precio base de 0.01 pesos
    And aplico un descuento del 40 por ciento
    When calculo el precio final con IVA
    Then el precio final debe ser positivo

  @regla3 @precioFinal @negativo @error
  Scenario: Error al calcular precio final con descuento inválido
    Given un producto "Agenda" con precio base de 30000 pesos
    When intento aplicar un descuento del 45 por ciento
    Then debe lanzar una excepción con el mensaje "El descuento debe estar entre 0% y 40%"
    And no se puede calcular el precio final
