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
    var interes = (depositado * 1.04)
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