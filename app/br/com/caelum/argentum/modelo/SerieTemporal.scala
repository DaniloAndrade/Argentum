package br.com.caelum.argentum.modelo

/**
	* Created by danilo on 27/05/16.
	*/
case class SerieTemporal(val candles: List[Candle]) {

	require(!candles.isEmpty)

	def candle(index: Int): Candle = candles(index)

	def ultimaPosicao = candles.size - 1
}
