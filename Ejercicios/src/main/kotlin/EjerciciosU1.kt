import java.text.DecimalFormat
import java.util.*

/**
 * Ejercicios de la U1:
 *
 * 4, 6, 12, 15, 18, 20, 21, 22, 24, 25, 26 y 27.
 *
 */


/**
 * Escribe un programa que le pida al usuario una temperatura en grados Celsius,
 *  la convierta a grados Fahrenheit e imprima por pantalla la temperatura convertida
 */
fun ejercicio4() {

    println("Introduce la temperatura en grados Celsius: ")
    val celsius = readln().toFloat()
    val fahrenheit = ((celsius*9/5) +32)
    println("La temperatura en fahrenheit es {$fahrenheit}")
}

/**
 * Escribe un programa que pida el importe final de un artículo y calcule
 *  e imprima por pantalla el IVA que se ha pagado y el importe sin IVA
 * (suponiendo que se ha aplicado un tipo de IVA del 10%).
 */

fun ejercicio6() {
    println("Indique el importe final: ")
    val impIVA = readln().toDouble()
    println("El importe sin IVA es ${"%.2f".format(impIVA/(1.1))}")

}

/**
 * Escribir un programa que pida al usuario su peso (en kg) y estatura (en metros),
 * calcule el índice de masa corporal y lo almacene en una variable, y muestre por pantalla la frase
 * Tu índice de masa corporal es donde es el índice de masa corporal calculado redondeado con dos decimales.
 */

fun ejercicio12(){
    println("Introduzca su peso en kg: ")
    val weight = readln().toDouble()
    println("Introduzca su altura en m: ")
    val height = readln().toDouble()
    val imc = (weight/(height*height))

    println("Su IMC es: ${"(%.2f)".format(imc)}")
}

/**
 * Imagina que acabas de abrir una nueva cuenta de ahorros que te ofrece el 4% de interés al año.
 * Estos ahorros debido a intereses, que no se cobran hasta finales de año, se te añaden al balance final
 * de tu cuenta de ahorros. Escribir un programa que comience leyendo la cantidad de dinero depositada en la cuenta de ahorros,
 * introducida por el usuario. Después el programa debe calcular y mostrar por pantalla la cantidad de ahorros tras el primer,
 * segundo y tercer años. Redondear cada cantidad a dos decimales.
 *
 * Calcula el interés: capital * (1 + interes)
 */

fun ejercicio15(){
    println("Introduzca la cantidad de dinero depositado en la cuenta (€): ")
    val depositado = readln().toDouble()
    val interes = (depositado * 1.04)
    println("Ahorros en el primer año: ${"(%.2f)".format(interes)}€")
    println("Ahorros en el segundo año: ${"(%.2f)".format(interes*(1.04))}€")
    println("Ahorros en el tercer año: ${"(%.2f)".format((interes*(1.04))*1.04)}€")

}

/**
 *Escribir un programa que pregunte el nombre completo del usuario en la consola y después muestre
 * por pantalla el nombre completo del usuario tres veces, una con todas las letras minúsculas,
 * otra con todas las letras mayúsculas y otra solo con la primera letra del nombre y de los apellidos
 * en mayúscula. El usuario puede introducir su nombre combinando mayúsculas y minúsculas como quiera.
 */

 fun ejercicio18(){
    println("Nombre completo: ")
    val nom = readln()
    /**
     * Con nomtitle lo que se está haciendo es con el split hacer una lista, con el join se pasa la lista
     * a cadena de caracteres separadas con un espacio pero Kotlin admite predicado, que lo que hace es
     * por cada elemento (it) coge el primer caracter y lo pone en mayúsculas
     */

    println ("${nom.lowercase()} - ${nom.uppercase()} - ${capitalize(nom)}")
       /**
         * - ${nom.replaceFirstChar {
         *         if (it.isLowerCase()) it.titlecase(
         *             Locale.getDefault()
         *         ) else it.toString()
         *     }}")
          */
    /** replace.FirstChar sólo coge el nombre, no los apellidos. Recorrer la cadena para que lo haga
     * bien. Crear una función, por ejemplo capitalize y con split en los espacios hacerlo
     */
    /** println ("${nom.lowercase()} - ${nom.uppercase()} - ${nom.split(' ').joinToString(" " )
    { it.replaceFirstChar (Char::uppercaseChar)}}").toString()
     */
 }

/**
 * Coge una cadena de caracteres, lo separa por palabras y a cada palabra le hace un CapitalLetter
 *
 * @param nombre String cadena de caracteres del nombre completo de una persona
 *
 * @return resultado cadena de caracteres con el nombre completo y cada palabra con CapitalLetter
 */

fun capitalize(nombre: String) : String {
    val cadena = nombre.lowercase().split(' ')
    var resultado = mutableListOf<String>()
    for (element in cadena){
        resultado.add(element.replaceFirstChar (Char::uppercaseChar))
    }
    return resultado.joinToString(" ")
}


/**
 * Los teléfonos de una empresa tienen el siguiente formato prefijo-número-extension donde
 * el prefijo es el código del país +34, y la extensión tiene dos dígitos (por ejemplo +34-913724710-56).
 * Escribir un programa que pregunte por un número de teléfono con este formato y muestre por pantalla el
 * número de teléfono sin el prefijo y la extensión.
 */

fun ejercicio20(){
    println("Introducta el teléfono con el siguiente formato: +xx-yyyyyyyy-zz (por ejemplo +34-913724710-56): ")
    val tel = readln()
    val lista: List<String> = tel.split('-').toList()
    println("El teléfono sin prefijo ni extensión es: ${lista[1]}")

}

/**
 * Escribir un programa que pida al usuario que introduzca una frase en la consola y muestre por pantalla la frase invertida
 */

fun ejercicio21() {
    println("Indique una frase: ")
    val frase = readln()
    println(frase.reversed())

}

/**
 * Escribir un programa que pida al usuario que introduzca una frase en la consola y una vocal,
 * y después muestre por pantalla la misma frase pero con la vocal introducida en mayúscula.
 */

fun ejercicio22() {
    println("Indique una frase: ")
    var frase = readln()
    println("Indique una vocal: ")
    val vocal = readln()

    println(frase.replace(vocal, vocal.uppercase()))

}

/**
* Escribir un programa que pregunte por consola el precio de un producto en euros con dos decimales
* y muestre por pantalla el número de euros y el número de céntimos del precio introducido.
*/

fun ejercicio24() {
    println("Introduzca un precio en € con 2 decimales: ")
    val precio = readln()
    val precio2 = precio.split(".")

    println("${precio2[0]} son los €, ${precio2[1]} son los céntimos.")

}

/**
 * Escribir un programa que pregunte al usuario la fecha de su nacimiento en formato dd/mm/aaaa
 * y muestra por pantalla, el día, el mes y el año. Adaptar el programa anterior para que también funcione
 * cuando el día o el mes se introduzcan con un solo carácter.
 */

fun ejercicio25() {
    println("Introduzca su fecha de nacimiento de la siguiente forma: dd/mm/aaaa: ")
    val fecha = readln()
    val fecha2 = fecha.split("/")

    println(" El día es: ${fecha2[0]}, del mes: ${fecha2[1]}, del año: ${fecha2[2]}")
}

/**
 * Escribir un programa que pregunte por consola por los productos de una cesta de la compra,
 * separados por comas, y muestre por pantalla cada uno de los productos en una línea distinta.
 */

fun ejercicio26() {
    println("Indique al lista de la compra, por ejemplo: tomate, lechuga, huevos...: ")
    var listaCompra = readln()
    listaCompra = listaCompra.replace(" ", "").replace(',','\n')

    println(listaCompra)

}

/**
 * Escribir un programa que pregunte el nombre el un producto, su precio y un número de unidades y muestre
 * por pantalla una cadena con el nombre del producto seguido de su precio unitario con 6 dígitos enteros y 2 decimales,
 * el número de unidades con tres dígitos y el coste total con 8 dígitos enteros y 2 decimales.
 */

fun ejercicio27() {
    println("Indique un producto: ")
    val producto = readln()

    println("Indique su precio: ")
    val precio = readln().toFloat()

    println("Indique el stock de ese producto: ")
    val ud = readln().toInt()

    val total = precio*ud

    val dfprec = DecimalFormat("000000.00")
    val dfunid = DecimalFormat("000")
    val dftotal = DecimalFormat("00000000.00")

    println("El nombre del producto es: ${producto}." +
            " \n El precio del producto es: ${dfprec.format(precio)}€." +
            " \n El stock es: ${dfunid.format(ud)}unidades." +
            " \n El coste total es:  ${dftotal.format(total)}€")
}