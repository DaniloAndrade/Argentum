package br.com.caelum.argentum.indicadores


import br.com.caelum.argentum.modelo.SerieTemporal

import scala.math.BigDecimal.RoundingMode


/**
	* Created by danilo on 27/05/16.
	*/
class MediaMovelSimples(intervalo:Int, indicador: Indicador) extends Indicador{
	require(intervalo != null)
	require(intervalo >= 0)

	def calcula(posicao:Int, serie:SerieTemporal) = (((posicao - (intervalo -1)) to posicao )
		.map(index =>  indicador.calcula(index,serie))
		.sum / intervalo).setScale(2, RoundingMode.HALF_UP)


	override def toString = "MMS Fechamento"
}
