## Análisis Levenshtein
* Podemos ver que el tiempo de ejecución del código aumenta considerablemente a partir de 7 carácteres de longitud.
* Cuando las cadenas son de igual longitud, la diferencia de ejecucion casi no cambia.
* En el caso de cadenas inversas el cambio ya se empieza a notar. Recordando la lógica del código, cada que no encuentra coincidencia en los caracteres, empieza a usar su recursividad reduciendo las cadenas de distintas formas para luego elegir el método con menor cantidad de movimientos. En este caso , literalmente tuvo que cambiar entre n y m(con n=longitud de la primera, m=longitud de la segunda) n-1 caracteres para llegar a m.
