package br.com.caelum.argentum.modelo

import java.time.LocalDateTime

/**
	* Created by danilo on 16/05/16.
	*/
object CandlestickFactory {

	def constroiCandles(negociacoes: List[Negociacao]):List[Candlestick] = {
		val negociacoesPorData = negociacoes.groupBy(n => LocalDateTime.of(n.data.getYear,n.data.getMonth,n.data.getDayOfMonth, 0, 0, 0) )
		negociacoesPorData.map((v) => constroiCandleParaData(v._1,v._2))
			.toList.sortWith((c1,c2) => c1.data.isBefore(c2.data))
	}


	def constroiCandleParaData(data:LocalDateTime, negociacoes:List[Negociacao]):Candlestick = {
		val precos = negociacoes.map(_.preco)

		val maximo = precos.reduceOption(_ max _).getOrElse(BigDecimal(0.0))
		val minimo = precos.reduceOption(_ min _ ).getOrElse(BigDecimal(0.0))
		val volume = negociacoes.map(_.volume).sum

		val abertura = negociacoes.headOption.map(_.preco).getOrElse(BigDecimal(0.0))
		val fechamento = negociacoes.lastOption.map(_.preco).getOrElse(BigDecimal(0.0))

		Candlestick(abertura,fechamento,minimo,maximo,volume,data)
	}
}
