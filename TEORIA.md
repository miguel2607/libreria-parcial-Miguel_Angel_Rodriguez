
## PREGUNTA 1: 

Un equipo de desarrollo termina de escribir toda la funcionalidad 
de un módulo y luego le pide al QA que diseñe las pruebas. Según
lo visto en clase, ¿cómo se llama este enfoque y cuál es su principal problema?

## RESPUESTA PREGUNTA 1
C. Desarrollo tradicional con pruebas al final. 
El problema es que los defectos se detectan tarde, 
cuando corregirlos cuesta hasta 100 veces más que si se hubieran 
encontrado en etapas tempranas.

## PREGUNTA 2: 

Un desarrollador escribe el siguiente ciclo: primero implementa 
la función `calcular_descuento()` completa con todos los casos que se 
le ocurren, luego escribe los tests para verificar que funciona. 
¿Qué regla de TDD está violando?

## PREGUNTA 2: 
B. La primera regla de Uncle Bob: no escribir código de producción 
sin que exista primero un test que falle. El código fue escrito antes 
de que ningún test lo requiriera.

## PREGUNTAS ABIERTAS

## PREGUNTA 1
Durante la semana 4 implementamos el carrito de compras con TDD y 
en el primer ciclo, el paso GREEN consistió en escribir el código más
simple posible aunque fuera "feo". Explica por qué TDD obliga a hacer
esto en el GREEN y qué pasaría con el proceso si el desarrollador aprovecha 
ese paso para escribir código "limpio y completo" desde el inicio.

## RESPUESTA PREGUNTA 1
TDD Obliga a hacer ese paso en green porque el objetivo del Test Driven 
Development es hacer que la prueba pase solo, da igual si no es el codigo 
perfecto, esto nos ayuda a ir mejorando el programa progresivamente paso a 
paso, en la proxima parte del TDD que es el refactor, ya escribimos mas limpio
y completo sin romper la logica del sistema.

## PREGUNTA 2
Explica con tus propias palabras la diferencia entre TDD y BDD. 
No es suficiente decir que uno usa código y el otro usa Gherkin. 
Explica qué problema resuelve cada uno, a quién está dirigido y 
por qué se complementan en lugar de reemplazarse.

## RESPUESTA PREGUNTA 2
TDD se enfoca en guiar el desarrollo del código a través de pruebas 
escritas por los desarrolladores, su objetivo es asegurar 
que cada parte del código funcione correctamente desde el inicio, claramente 
respetando el proceso de TDD (RED,GREEN,REFACTOR), en cambio el 
BDDse centra en el comportamiento del sistema desde
una vista del usuario o negocio, usando escenarios entendibles 
por todos como personas que no tienen ningun conocimiento tecnico, en este
usamos palabras reservadas como (THEN, WHERE, GIVEN).

## PREGUNTA 4
En el contexto de la Regla 2 del examen (descuento entre 0% y 40%), 
un compañero dice que basta con probar el descuento del 20% porque 
"si funciona con ese valor, funciona con todos". 
Explica por qué esa lógica es incorrecta y qué valores concretos 
deberías probar tú y por qué.

## RESPUESTA PREGUNTA 4
Esa lógica es incorrecta porque probar un solo valor no garantiza que
todos los demás funcionen igual. Ya que no se va a abarcar el ´porcentaje 
minimo que se necesita para que todas las pruebas pasen y tener un buen 
sistema, solo vamos a abarcar una pequeña parte pero tranquilamente 
el descuento del 40% puede fallar ya que no se probo o algun otro tipo de 
descuento. 

## PREGUNTA 5
Mirando el planeador de la asignatura, las semanas 3 y 4 cubren pruebas 
ágiles, TDD y BDD. Explica cómo estas prácticas se conectan con el concepto
de CI/CD que veremos en la semana 6. ¿Qué pasaría con un pipeline de CI/CD 
si el equipo no tiene una suite de tests automatizados sólida?
## RESPUESTA PREGUNTA 5
Las prácticas como TDD y BDD son fundamentales para CI/CD porque permiten 
tener pruebas automatizadas que revisan el sistema constantemente.
En un pipeline de CI/CD, cada cambio en el código se une o integra y se prueba 
automáticamente, Si el equipo no tiene pruebas sólidas, el pipeline no 
puede detectar errores, lo que significa que se pueden desplegar fallos
a producción.
