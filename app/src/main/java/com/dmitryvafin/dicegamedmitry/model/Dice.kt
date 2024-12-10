package com.dmitryvafin.dicegamedmitry.model

class Dice(lados: Int) {
    var lados: Int = lados
        private set

    var quantityOfThrows: Int = 0
        private set

    constructor() : this(6)

    fun throwDice(): Int {
        quantityOfThrows++
        return (1..lados).random()
    }

    companion object {
        fun throwDiceNFaces(faces: Int): Int {
            return (1..faces).random()
        }
    }

    override fun toString(): String {
        return "Dado de $lados lados, lanzado $quantityOfThrows veces."
    }
}
