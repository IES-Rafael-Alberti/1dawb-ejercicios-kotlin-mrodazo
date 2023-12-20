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
        } else {
            println("Contraseña incorrecta")
        }
    }
}

/**
 * Ejercicio 2.1.3
 * Escribir un programa que pida al usuario dos números y muestre por pantalla su división.
 * Si el divisor es cero el programa debe mostrar un error.
 */

fun division(num1: Int, num2: Int): Float {
    return (num1.toFloat() / num2.toFloat())
}

fun ejercicio203() {

    println("Introduce el dividendo: ")
    val dividendo = readln().toInt()

    println("Introduce el divisor: ")
    val divisor = readln().toInt()

    if (divisor != 0) {
        println("El resultado es ${"(%.2f)".format(division(dividendo, divisor))}")
    } else {
        println("**ERROR** El divisor es 0, introduzca otra división")
        main()
    }
}

fun esLetraAnterior(letra_a: String, letra_b: String): Boolean {
    return letra_a < letra_b
}

fun perteneceGrupo(sexo: String, nombre: String): String {

    val inicialNombre = nombre[0].uppercase()

    if (
        (sexo.lowercase() == "hombre" && esLetraAnterior("N", inicialNombre))
        ||
        (sexo.lowercase() == "mujer" && esLetraAnterior(inicialNombre, "M"))
    ) {
        return "A"
    }
    return "B"
}

/**
 * Otra forma de hacer la función pero quitando código. Cuando sólo tiene que devolver un valor,
 * hacer sólo un cálculo, es mejor así ya que If y Else devuelven un valor, por eso no se pone return.
 * Lo que siempre hay que decirle si no es una cosa, que es entonces (else).
 */
fun perteneceGrupo1(sexo: String, nombre: String) =
    if (
        (sexo.lowercase() == "hombre" && esLetraAnterior("N", nombre[0].uppercase()))
        ||
        (sexo.lowercase() == "mujer" && esLetraAnterior(nombre[0].uppercase(), "M"))
    ) {
        "A"
    } else {
        "B"
    }

/**
 * Ejercicio 2.1.6
 * Los alumnos de un curso se han dividido en dos grupos A y B de acuerdo al sexo y el nombre.
 * El grupo A esta formado por las mujeres con un nombre anterior a la M y los hombres con un
 * nombre posterior a la N y el grupo B por el resto. Escribir un programa que pregunte al
 * usuario su nombre y sexo, y muestre por pantalla el grupo que le corresponde.
 */

fun ejercicio206() {

    println("Introduce tu nombre: ")
    val nombre = readln()

    println("Introduce tu sexo (mujer/hombre): ")
    val sexo = readln()

    println("Usted pertenece al grupo: ${perteneceGrupo1(sexo, nombre)}")

}

fun comprobarPuntuacion(puntos: Double) =
        ((puntos == 0.0) || (puntos == 0.4) || (puntos >= 0.6))

fun nivel (puntos: Double) : String {
    if (puntos == 0.0) {
        return "Nivel inaceptable"
    }
    else if (puntos == 0.4) {
        return "Nivel aceptable"
    }
    else if (puntos >= 0.6) {
        return 'Nivel meritorio'
    }
    else {

    }

}

/**
 * Ejercicio 2.1.8
 * En una determinada empresa, sus empleados son evaluados al final de cada año.
 * Los puntos que pueden obtener en la evaluación comienzan en 0.0 y pueden ir aumentando,
 * traduciéndose en mejores beneficios. Los puntos que pueden conseguir los empleados pueden
 * ser 0.0, 0.4, 0.6 o más, pero no valores intermedios entre las cifras mencionadas.
 * A continuación se muestra una tabla con los niveles correspondientes a cada puntuación.
 * La cantidad de dinero conseguida en cada nivel es de 2.400€ multiplicada por la puntuación del nivel.
 *
 * Nivel Inaceptable --> Puntuación 0.0
 * Nivel Aceptable --> Puntuación 0.4
 * Nivel Meritorio --> Puntuación 0.6 o más
 */

fun ejercicio208 (){



}