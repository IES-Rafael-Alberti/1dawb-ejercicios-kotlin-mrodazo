/**
 * U3:
 * Listas y tuplas: 4, 6, 8, 9, 10 y 13.
 * Diccionarios: 3, 5, 6, 7, 8, 10 y 11.
 * Conjuntos: 1, 2, 3, 4, 5 y 6.
 */


/**
 * Ejercicio 3.3.1¶
 * Suponer una lista con datos de las compras hechas por clientes de una empresa a lo largo de un mes, la cual contiene tuplas con información de cada venta: (cliente, día del mes, monto, domicilio del cliente). Ejemplo:
 *
 * [("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"), ("Jorge Russo", 7, 699, "Mirasol 218"), ("Nuria Costa", 7, 532.90, "Calle Las Flores 355"), ("Julián Rodriguez", 12, 5715.99, "La Mancha 761"), ("Jorge Russo", 15, 958, "Mirasol 218")]
 * Escribir una función que reciba como parámetro una lista con el formato mencionado anteriormente y retorne los domicilios de cada cliente al cual se le debe enviar una factura de compra. Notar que cada cliente puede haber hecho más de una compra en el mes, por lo que la función debe retornar una estructura que contenga cada domicilio una sola vez.
 */

fun ejercicio331 () {

    /*
    Una forma:
    val listaCompras = mutableListOf<List<Any>>()

    listaCompras.add (listof("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"))
    listaCompras.add (listof("Jorge Russo", 7, 699, "Mirasol 218"))
    listaCompras.add (listof("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"))
    listaCompras.add (listof("Julián Rodriguez", 12, 5715.99, "La Mancha 761"))
    listaCompras.add (listof("Jorge Russo", 15, 958, "Mirasol 218))

     */

    val listaCompras: List<List<Any>> = listOf(
        listOf("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"),
        listOf("Jorge Russo", 7, 699, "Mirasol 218"),
        listOf("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"),
        listOf("Julián Rodriguez", 12, 5715.99, "La Mancha 761"),
        listOf("Jorge Russo", 7, 699, "Mirasol 218")
    )

    println(domicilios(listaCompras).joinToString(", "))
}

fun domicilios(compras: List<List<Any>>) : List<String> {

    /**Una forma:
     * val listaDomicilios = mutableListOf<String>() //Mutable porque la lista se crea con cada iteración
     *     compras.forEach { elemento -> listaDomicilios.add(elemento[3].toString()) }
     *     /**Te coge todos los elementos de la lista y los pasa a conjunto, como los conjuntos no tienen
     *     elementos duplicados. Después lo pasamos a una lista porque hemos dicho que la salida
     *      fuera una lista.
     *      Con sorted se ordena la lista
     *      */
     *     return listaDomicilios.toSet().toList().sorted()
     *
     *     Otra, usando el map que coge la lista ygenera otra cogiendo la info entre las llaves
     */

    return compras.map{ it[3].toString() }.toSet().toList().sorted()

}