package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  val clienteEnojado = Cliente(enojado, 100)
  val clienteDeFeliz = Cliente(feliz, 100)
  val clienteIndiferente = Cliente(indiferente, 100)
  val clienteResfriado = Cliente(resfriado, 100)


  describe("Propinas por estado de animo") {
    it("Cliente feliz") {
      clienteEnojado.propinaPorAnimo(1000).shouldBe(0)
    }

    it("Cliente enojado") {
      clienteDeFeliz.propinaPorAnimo(200).shouldBe(50)
    }

    it("Cliente indiferente") {
      clienteIndiferente.propinaPorAnimo(300).shouldBe(100)
    }

    it("Cliente resfriado") {
      clienteResfriado.propinaPorAnimo(150).shouldBe(150)
    }
  }

  describe("Propina Por ubicación") {

    describe("En Las Rosas") {
      ubicacion.barrio = lasRosas

      it("Cliente enojado") {
        clienteEnojado.propinaPorBarrio(1000).shouldBe(50)
      }

      it("Cliente feliz") {
        clienteDeFeliz.propinaPorBarrio(200).shouldBe(100)
      }

      it("Cliente indiferente") {
        clienteIndiferente.propinaPorBarrio(300).shouldBe(150)
      }

      it("Cliente resfriado") {
        clienteResfriado.propinaPorBarrio(150).shouldBe(200)
      }
    }

    describe("En Las Lauchas") {
      ubicacion.barrio = lasLauchas

      it("Cliente enojado") {
        clienteEnojado.propinaPorBarrio(1000).shouldBe(0)
      }

      it("Cliente feliz") {
        clienteDeFeliz.propinaPorBarrio(200).shouldBe(25)
      }

      it("Cliente indiferente") {
        clienteIndiferente.propinaPorBarrio(300).shouldBe(50)
      }

      it("Cliente resfriado") {
        clienteResfriado.propinaPorBarrio(150).shouldBe(75)
      }
    }

    describe("En Barrio Verde") {
      ubicacion.barrio = barrioVerde

      it("Cliente enojado") {
        clienteEnojado.propinaPorBarrio(1000).shouldBe(200)
      }

      it("Cliente feliz") {
        clienteDeFeliz.propinaPorBarrio(200).shouldBe(200)
      }

      it("Cliente indiferente") {
        clienteIndiferente.propinaPorBarrio(300).shouldBe(200)
      }

      it("Cliente resfriado") {
        clienteResfriado.propinaPorBarrio(150).shouldBe(200)
      }
    }

    describe("En Las Torres") {
      ubicacion.barrio = lasTorres

      it("Cliente feliz") {
        clienteEnojado.propinaPorBarrio(1000).shouldBe(0)
      }

      it("Cliente enojado") {
        clienteDeFeliz.propinaPorBarrio(200).shouldBe(50)
      }

      it("Cliente indiferente") {
        clienteIndiferente.propinaPorBarrio(300).shouldBe(100)
      }

      it("Cliente resfriado") {
        clienteResfriado.propinaPorBarrio(150).shouldBe(150)
      }
    }

  }
})
