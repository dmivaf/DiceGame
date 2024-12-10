package com.dmitryvafin.dicegamedmitry.model

fun main() {

    var lados: Int? = null

    while (lados == null || lados !in 4..20) {
        println("Introduce el número de caras del dado (entre 4 y 20):")
        lados = readLine()?.toIntOrNull()

        if (lados == null || lados !in 4..20) {
            println("Número de caras inválido. Debes introducir un valor entre 4 y 20.")
        }
    }

    val dado = Dice(lados)
    var previousThrow = dado.throwDice()
    println("Has lanzado el dado y ha salido: $previousThrow")

    while (true) {
        var guess: String?

        do {
            println("Crees que saldrá un número mayor o menor? (Escribe 'mayor' o 'menor'):")
            guess = readLine()?.lowercase()
        } while (guess != "mayor" && guess != "menor")

        val currentThrow = dado.throwDice()
        println("Has lanzado el dado y ha salido: $currentThrow")

        val correctGuess = when {
            guess == "mayor" && currentThrow > previousThrow -> true
            guess == "menor" && currentThrow < previousThrow -> true
            else -> false
        }

        if (!correctGuess) {
            println("Te has equivocado. Fin del juego.")
            break
        }

        previousThrow = currentThrow
    }

    println("Información del dado usado: ${dado}")
}
