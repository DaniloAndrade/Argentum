package br.com.caelum.argentum.indicadores

import br.com.caelum.argentum.modelo.SerieTemporal

/**
	* Created by danilo on 27/05/16.
	*/
class MediaMovelPonderada {
	def calcula(posicao:Int, serie:SerieTemporal):BigDecimal = {

		def calculaComPeso(posicoes: List[Int], peso:Int, serieTemporal: SerieTemporal):List[BigDecimal] = {
			posicoes match {
				case Nil => BigDecimal(0)::Nil
					case head::tail => (serieTemporal.candles(head).fechamento * peso) :: calculaComPeso(tail,peso - 1,serieTemporal)
			}
		}

		val posicoes = ((posicao - 2) to posicao).reverse.toList
		calculaComPeso(posicoes,3,serie).sum / 6

	}
}
