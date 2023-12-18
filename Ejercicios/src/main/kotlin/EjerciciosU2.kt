/**
 * U2:
 *   Sentencias condicionales: 2, 3, 6, 8 y 10.
 *   Sentencias iterativas: 2, 4, 6, 7, 8, 13, 15, 18, 19 y 25.
 *   Captura de excepciones: 2, 3 y 4.
 */



/**
 * Ejercicio 2.1.2
 * Escribir un programa que almacene la cadena de caracteres contraseña en una variable,
 * pregunte al usuario por la contraseña e imprima por pantalla si la contraseña introducida por el
 * usuario coincide con la guardada en la variable sin tener en cuenta mayúsculas y minúsculas.
 */

/**
 * Función que compara 2 Strings para ver si son iguales. Para ello los pasa a minúsculas.
 * Retorna verdadero o falso
 */
fun comparaContrasena(string: String, string2: String): Boolean {
    return string.lowercase() == string2.lowercase()
}

fun ejercicio202() {
    val passw1 = "Contrasena"
    var intento = true

    while (intento) {
        println("Introduzca la contraseña: ")
        val passw2 = readln()
        if (comparaContrasena(passw1, passw2)) {
            println("Contraseña correcta")
            intento = false
        }
        else {
            println("Contraseña incorrecta")
        }
    }
}

/**
 * Ejercicio 2.1.3
 * Escribir un programa que pida al usuario dos números y muestre por pantalla su división.
 * Si el divisor es cero el programa debe mostrar un error.
 */

fun division (num1: Int, num2: Int): Float {
    return (num1.toFloat()/num2.toFloat())
}

fun ejercicio203(){

    println("Introduce el dividendo: ")
    val dividendo = readln().toInt()

    println("Introduce el divisor: ")
    val divisor = readln().toInt()

    if (divisor!=0){
        println("El resultado es ${"(%.2f)".format(division(dividendo,divisor))}")
    }
    else {
        println("**ERROR** El divisor es 0, introduzca otra división")
        main()
    }
}