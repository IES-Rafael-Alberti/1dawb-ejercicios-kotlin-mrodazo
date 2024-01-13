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


/**
 * Ejercicio 2.1.8
 * En una determinada empresa, sus empleados son evaluados al final de cada año. Los puntos que pueden obtener
 * en la evaluación comienzan en 0.0 y pueden ir aumentando, traduciéndose en mejores beneficios. Los puntos que
 * pueden conseguir los empleados pueden ser 0.0, 0.4, 0.6 o más, pero no valores intermedios entre las cifras
 * mencionadas. A continuación se muestra una tabla con los niveles correspondientes a cada puntuación. La cantidad
 * de dinero conseguida en cada nivel es de 2.400€ multiplicada por la puntuación del nivel.
 *
 * Nivel	Puntuación
 * Inaceptable	0.0
 * Aceptable	0.4
 * Meritorio	0.6 o más
 *
 * Escribir un programa que lea la puntuación del usuario e indique su nivel de rendimiento, así como la cantidad
 * de dinero que recibirá el usuario.
 */


fun comprobarPuntuacion(puntos: Double): Boolean =
    ((puntos == 0.0) || (puntos == 0.4) || (puntos in 0.6..1.0))

fun comprobarDouble(entrada: String): Boolean {
    try {
        entrada.toDouble()
    } catch (e: NumberFormatException) {
        return false
    }
    return true
}

fun indicarNivel(puntos: Double): String {
    val nivel: String
    when (puntos) {
        0.0 -> {
            nivel = "inaceptable"
        }

        0.4 -> {
            nivel = "aceptable"
        }

        else -> {
            nivel = "meritorio"
        }
    }
    return nivel
}

fun bonificacion(puntos: Double) = (puntos * 2400)


fun ejercicio208() {

    var exito = false

    while (!exito) {
        println("Introduzca su puntuación: ")
        val entrada = readln()

        if (comprobarDouble(entrada)) {
            val puntos = entrada.toDouble()
            if (comprobarPuntuacion(puntos)) {
                println("Nivel ${indicarNivel(puntos)}, su bonificación es: %.2f".format(bonificacion(puntos)) + "€")
                exito = true
            } else {
                println("Puntuación no válida, introduzca una correcta.")
            }
        } else {
            println("Formato no válido, introduzca: 0.0, 0.4 o de 0.6 a 1.0")
        }
    }
}

/**
 * Ejercicio 2.1.10¶
 * La pizzería Bella Napoli ofrece pizzas vegetarianas y no vegetarianas a sus clientes. Los ingredientes para cada tipo de pizza aparecen a continuación.
 *
 * Ingredientes vegetarianos: Pimiento y tofu.
 * Ingredientes no vegetarianos: Peperoni, Jamón y Salmón.
 *
 * Escribir un programa que pregunte al usuario si quiere una pizza vegetariana o no, y en función de su respuesta le muestre un menú con los ingredientes disponibles para que elija. Solo se puede eligir un ingrediente además de la mozzarella y el tomate que están en todas la pizzas. Al final se debe mostrar por pantalla si la pizza elegida es vegetariana o no y todos los ingredientes que lleva.
 */

fun comprobarTipo(respuestaPizza: String) = (respuestaPizza == "v" || respuestaPizza == "n")

fun mostrarMenu(respuestaPizza: String): Set<String> {
    var menu = mutableListOf<String>()
    when (respuestaPizza) {
        "v" -> menu = mutableListOf("pimiento", "tofu")
        "n" -> menu = mutableListOf("peperoni", "jamón", "salmón")
    }
    return menu.toSet()
}

fun comprobarIngrediente(menu: Set<String>, ingrediente: String) : Boolean  = ingrediente in menu


fun tipoPizza (respuestaPizza: String) : String {
    var pizza = ""

    when(respuestaPizza) {
        "v" -> pizza = "vegetariana"
        "n" -> pizza = "no vegetariana"
    }
    return pizza
}

fun ingredientesElegidos (ingrediente: String) : String {
    val ingredientes = mutableListOf<String>("mozzarella", "tomate")

    ingredientes.add(ingrediente)

    return (ingredientes.toSet().joinToString(", "))
}

fun ejercicio2010() {
    var exito = false

    while (!exito) {
        println("¿Desea pizza vegetariana (v) o no vegetariana (n)?")
        val respuestaPizza = readln().lowercase()
        if (comprobarTipo(respuestaPizza)) {
            val menu = mostrarMenu(respuestaPizza)
            println("¿Qué ingrediente desea, además de mozarella y tomate? $menu")
            val ingrediente = readln().lowercase()
            if (comprobarIngrediente(menu, ingrediente)) {
                val pizza = tipoPizza(respuestaPizza)
                println("La pizza escogida es $pizza y los ingredientes son ${ingredientesElegidos(ingrediente)}")
                exito = true
            } else {
                println("El ingrediente que indica no está disponible, por favor elija de nuevo el tipo de pizza y un ingrediente del menú")
            }
        }
        else {
            println("El tipo de pizza escogida no la tenemos, por favor elija vegetariana (v) o no vegetariana(n)")
        }
    }
}


fun ejercicio2010__2() {
    var exitoTipo = false

    while (!exitoTipo) {
        println("¿Desea pizza vegetariana (v) o no vegetariana (n)?")
        val respuestaPizza = readln().lowercase()
        if (comprobarTipo(respuestaPizza)) {
            exitoTipo = true
            val menu = mostrarMenu(respuestaPizza)

            var exitoIngrediente = false
            while (!exitoIngrediente) {
                println("¿Qué ingrediente desea, además de mozarella y tomate? $menu")
                val ingrediente = readln().lowercase()
                if (comprobarIngrediente(menu, ingrediente)) {
                    val pizza = tipoPizza(respuestaPizza)
                    println("La pizza escogida es $pizza y los ingredientes son ${ingredientesElegidos(ingrediente)}")
                    exitoIngrediente = true
                } else {
                    println("El ingrediente que indica no está disponible, por favor elija de nuevo el tipo de pizza y un ingrediente del menú")
                }
            }
        }
        else {
            println("El tipo de pizza escogida no la tenemos, por favor elija vegetariana (v) o no vegetariana(n)")
        }
    }
}

        /**
         * Ejercicio 2.1.25 creo
         */

        fun ejercicio2125() {

            println("Introduzca una frase")

            val frase = readln()

            val listaPalabras = frase.split(' ')

            var palabraMayor = ""

            var cont = 0


            for (palabra in listaPalabras) {
                if (palabra.length > palabraMayor.length) {
                    palabraMayor = palabra
                    cont = 1
                } else if (palabra.length == palabraMayor.length) {
                    cont++
                }
            }

            println(
                "La palabra mayor es $palabraMayor y aparecen $cont palabras del mismo tamaño, en total" +
                        " hay ${listaPalabras.size} palabras."
            )

        }