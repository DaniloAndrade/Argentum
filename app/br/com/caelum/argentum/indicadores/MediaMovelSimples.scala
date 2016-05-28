package br.com.caelum.argentum.indicadores

import br.com.caelum.argentum.modelo.SerieTemporal

/**
	* Created by danilo on 27/05/16.
	*/
class MediaMovelSimples {

	def calcula(posicao:Int, serie:SerieTemporal) = ((posicao - 2) to posicao )
		.map(index =>  serie.candle(index))
		.map(c => c.fechamento).sum / 3
}
