package br.com.caelum.argentum.tests.indicadores

import br.com.caelum.argentum.indicadores._
import org.specs2.mutable.Specification

/**
	* Created by danilo on 01/06/16.
	*/
class IndicadoresTest extends Specification{


	"dado a sigla " >> {

		"IF deve criar IndicadoFechamento" >> {
			val siglaIndicador = "IF"
			Indicadores.criar(siglaIndicador) must beAnInstanceOf[IndicadorFechamento]
		}

		"IA deve criar IndicadoAbertura" >> {
			val siglaIndicador = "IA"
			Indicadores.criar(siglaIndicador) must beAnInstanceOf[IndicadorAbertura]
		}

		"MMS deve cria MediaMovelSimples" >> {
			val siglaIndicador = "IF"
			val siglaIndicadorComposto = "MMS"
			val indicadorFechamento = Indicadores.criar(siglaIndicador)
			Indicadores.criarIndicadorComposto(siglaIndicadorComposto)(3,indicadorFechamento) must beAnInstanceOf[MediaMovelSimples]
		}

		"MMP deve cria MediaMovelPonderada" >> {
			val siglaIndicador = "IF"
			val siglaIndicadorComposto = "MMP"
			val indicadorFechamento = Indicadores.criar(siglaIndicador)
			Indicadores.criarIndicadorComposto(siglaIndicadorComposto)(3,indicadorFechamento) must beAnInstanceOf[MediaMovelPonderada]
		}
	}
}
