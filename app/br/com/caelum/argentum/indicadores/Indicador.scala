package br.com.caelum.argentum.indicadores

import br.com.caelum.argentum.modelo.SerieTemporal

/**
	* Created by danilo on 31/05/16.
	*/
trait Indicador {
	 def calcula(posicao:Int, serie:SerieTemporal):BigDecimal
}
