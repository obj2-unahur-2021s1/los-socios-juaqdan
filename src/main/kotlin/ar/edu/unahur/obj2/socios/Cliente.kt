package ar.edu.unahur.obj2.socios

import kotlin.math.max

abstract class Estado {
    abstract fun propina(unImporte: Int, unCliente: Cliente) : Int

}

object enojado: Estado() {
    override fun propina(unImporte : Int, unCliente: Cliente) = 0
}

object feliz: Estado() {
    override fun propina(unImporte : Int, unCliente: Cliente) = (unImporte / 100) * 25
}

object indiferente: Estado() {
    override fun propina(unImporte : Int, unCliente: Cliente): Int = unCliente.bolsillo
}

object resfriado: Estado() {
    override fun propina(unImporte: Int, unCliente: Cliente) = unImporte
}

/**************Barrio**************/

abstract class Barrio(){
   abstract fun calcularPropina(unaPropina: Int) : Int
}

object LasRosas : Barrio(){
    override fun calcularPropina(unaPropina: Int) = unaPropina + 50
}
object LasLauchas : Barrio(){
    override fun calcularPropina(unaPropina: Int) = unaPropina / 2
}
object BarrioVerde : Barrio(){
    override fun calcularPropina(unaPropina: Int) = max(unaPropina, 200)
}
object LasTorres : Barrio() {
    override fun calcularPropina(unaPropina: Int) = unaPropina
}

class Cliente(val estadoDeAnimo: Estado, var bolsillo: Int, var barrio : Barrio) {

    fun propina(unImporte: Int) = estadoDeAnimo.propina(unImporte, this)

    fun cuantaPropinaDejaria(unImporte: Int) = barrio.calcularPropina(this.propina(unImporte))

}
