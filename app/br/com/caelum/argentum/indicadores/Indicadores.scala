package br.com.caelum.argentum.indicadores

/**
	* Created by danilo on 01/06/16.
	*/
object Indicadores extends Enumeration{
	def criar(siglaIndicador: String) = {
		val sigla = withName(siglaIndicador)
		sigla match {
			case IF => new IndicadorFechamento
			case IA => new IndicadorAbertura
			case _ => throw new IllegalArgumentException("Não é um Indicador Base")
		}
	}

	def criarIndicadorComposto(siglaIndicador: String) = {
		val sigla = withName(siglaIndicador)
		sigla match {
			case MMS => MediaMovelSimples
			case MMP => MediaMovelPonderada
			case _ => throw new IllegalArgumentException("Não é um Indicador Composto")
		}
	}



	val MMS = Value("MMS")
	val MMP = Value("MMP")
	val IF = Value("IF")
	val IA = Value("IA")

}
