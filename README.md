# Librería 


## Reglas 

### Regla 1: Producto
Un producto tiene nombre y precio base. El precio base
debe ser mayor que cero. Si se intenta crear un producto con 
precio cero o negativo, el sistema debe rechazarlo con un mensaje claro.

### Regla 2: Descuentos
Se puede aplicar un descuento porcentual al producto. 
El descuento debe estar entre 0% y 40%. Un descuento mayor al 40%
debe ser rechazado. Un descuento del 0% es válido.

### Regla 3: Cálculo de Precio Final
El precio final se calcula aplicando primero 
el descuento y luego el IVA del 19% sobre el resultado. 
El precio final nunca puede ser negativo.

---


### Particiones de Equivalencia - Regla 1 
| Partición | Descripción | Valor Representativo | Resultado Esperado |
|----------------------------------------------------------------|
| **PE1-V** | Precio base válido (> 0) | 10000 | Producto creado exitosamente |
| **PE1-I1** | Precio base igual a cero | 0 | Rechazo con mensaje: "El precio base debe ser mayor que cero" |
| **PE1-I2** | Precio base negativo | -5000 | Rechazo con mensaje: "El precio base debe ser mayor que cero" |

### Particiones de Equivalencia - Regla 2 (Descuento)

| Partición | Descripción | Valor Representativo | Resultado Esperado |
|----------------------------------------------------------------|
| **PE2-V** | Descuento válido (0% - 40%) | 20% | Descuento aplicado correctamente |
| **PE2-VL** | Descuento en límite inferior válido | 0% | Descuento aplicado (sin descuento) |
| **PE2-VH** | Descuento en límite superior válido | 40% | Descuento aplicado correctamente |
| **PE2-I1** | Descuento negativo | -10% | Rechazo con mensaje: "El descuento debe estar entre 0% y 40%" |
| **PE2-I2** | Descuento mayor al límite permitido | 50% | Rechazo con mensaje: "El descuento debe estar entre 0% y 40%" |

### Análisis de Valores Límite - Regla 2 

| Valor Crítico | Descripción | Resultado Esperado |
|-----------------------------------------------|
| **-1%** | Justo debajo del límite inferior | Rechazo: descuento inválido |
| **0%** | Límite inferior exacto | Aceptado: descuento válido |
| **0.01%** | Justo encima del límite inferior | Aceptado: descuento válido |
| **39.99%** | Justo debajo del límite superior | Aceptado: descuento válido |
| **40%** | Límite superior exacto | Aceptado: descuento válido |
| **40.01%** | Justo encima del límite superior | Rechazo: descuento inválido |
| **41%** | Claramente fuera del rango | Rechazo: descuento inválido |

### Pregunta para el Administrador - Regla 3

**Pregunta:** ¿Pueden aplicarse múltiples descuentos o 
promociones acumuladas a un mismo producto que podrían superar 
el 40% individual establecido?

**Justificación:** La Regla 3 indica que "el precio final nunca 
puede ser negativo", pero matemáticamente con las Reglas 1 y 2 esto
es imposible (precio > 0 y descuento máximo 40%). Esto sugiere 
que podrían existir descuentos adicionales no documentados que
debemos considerar en el diseño.

