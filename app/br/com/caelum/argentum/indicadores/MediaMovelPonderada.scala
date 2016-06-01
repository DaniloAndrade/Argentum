package br.com.caelum.argentum.indicadores

import br.com.caelum.argentum.modelo.SerieTemporal

/**
	* Created by danilo on 27/05/16.
	*/
class MediaMovelPonderada(intervalo:Int, indicador: Indicador) extends Indicador{

	require(intervalo != null)
	require(intervalo >= 0)

	def calcula(posicao:Int, serie:SerieTemporal):BigDecimal = {

		def calculaComPeso(posicoes: List[Int], peso:Int, serieTemporal: SerieTemporal):List[BigDecimal] = {
			posicoes match {
				case Nil => BigDecimal(0)::Nil
				case head::tail => (indicador.calcula(head,serieTemporal) * peso) :: calculaComPeso(tail,peso - 1,serieTemporal)
			}
		}

		val posicoes = ((posicao - (intervalo - 1)) to posicao).reverse.toList
		calculaComPeso(posicoes,intervalo,serie).sum / (intervalo * 2)

	}


	override def toString = "MMP Fechamento"
}
