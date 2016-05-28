package br.com.caelum.argentum.tests.indicadores

import java.time.LocalDateTime

import br.com.caelum.argentum.modelo.{Candle, SerieTemporal}

/**
	* Created by danilo on 27/05/16.
	*/
object GeradoreDeSerie {

	def apply(values: BigDecimal*): SerieTemporal =
		SerieTemporal(values.map(v => Candle(v, v, v, v, 1000, LocalDateTime.now())).toList)
}
