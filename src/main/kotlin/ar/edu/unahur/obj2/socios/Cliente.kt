package ar.edu.unahur.obj2.socios

import kotlin.math.max



class Cliente(val estadoDeAnimo: Animo, val bolsillo: Int) {

    fun propinaPorAnimo(unImporte: Int) = estadoDeAnimo.propinaDeClientePorImporte(this, unImporte)

    fun propinaPorBarrio(unImporte: Int) = ubicacion.barrio.variacionDe(propinaPorAnimo(unImporte))
}

/*****Singleton*******/
object ubicacion{
    var barrio: Barrio = lasRosas
}


/*******Strategy*********/
//***************************Estados de animo******************************************************

abstract class Animo {
    abstract fun propinaDeClientePorImporte(unCliente: Cliente, unImporte: Int): Int
}

object enojado: Animo() {
    override fun propinaDeClientePorImporte(unCliente: Cliente, unImporte: Int) = 0
}

object feliz: Animo() {
    override fun propinaDeClientePorImporte(unCliente: Cliente, unImporte: Int) = (unImporte * 0.25).toInt()
}

object indiferente: Animo() {
    override fun propinaDeClientePorImporte(unCliente: Cliente, unImporte: Int) = unCliente.bolsillo
}

object resfriado: Animo() {
    override fun propinaDeClientePorImporte(unCliente: Cliente, unImporte: Int) = unImporte
}


//***************************Barrios************************************************************


abstract class Barrio{
    abstract fun variacionDe(unaPropina: Int): Int
}

object lasRosas : Barrio(){
    override fun variacionDe(unaPropina: Int) = unaPropina + 50
}

object lasLauchas : Barrio(){
    override fun variacionDe(unaPropina: Int) = unaPropina / 2
}

object barrioVerde : Barrio(){
    override fun variacionDe(unaPropina: Int) = max(200, unaPropina)
}

object lasTorres : Barrio(){
    override fun variacionDe(unaPropina: Int) = unaPropina
}