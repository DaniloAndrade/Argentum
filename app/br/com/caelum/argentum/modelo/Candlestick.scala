package br.com.caelum.argentum.modelo

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
	* Created by danilo on 16/05/16.
	*/
case class Candlestick(val abertura: BigDecimal,
											 val fechamento: BigDecimal,
											 val minimo: BigDecimal,
											 val maximo: BigDecimal,
											 val volume: BigDecimal,
											 val data: LocalDateTime) {

	require(abertura >= 0, "Preço abertura não deve ser negativo")
	require(fechamento >= 0, "Preço fechamento não deve ser negativo")
	require(minimo >= 0, "Preço minimo não deve ser negativo")
	require(maximo >= 0, "Preço máximo não deve ser negativo")
	require(data != null, "Preço data não deve ser preenchida")
	require(maximo >= minimo, "Preço maximo deve ser maior ou igual ao minimo ")

	val format = DateTimeFormatter.ofPattern("dd/MM/yyyy")


	def isAlta = fechamento >= abertura

	def isBaixa = abertura > fechamento

	override def toString: String = s"[Abertura $abertura, Fechamento $fechamento, Mínima $minimo, Máxima $maximo, Volume $volume, Data ${data.format(format)}]"

}


class CandlestickBuilder {
	var abertura: BigDecimal = 0.0
	var fechamento: BigDecimal = 0.0
	var minimo: BigDecimal = 0.0
	var maximo: BigDecimal = 0.0
	var volume: BigDecimal = 0.0
	var data: LocalDateTime = LocalDateTime.now()

	def comAbertura(abertura: BigDecimal) = {
		this.abertura = abertura
		this
	}

	def comFechamento(fechamento: BigDecimal) = {
		this.fechamento = fechamento
		this
	}

	def comMinimo(minimo: BigDecimal) = {
		this.minimo = minimo
		this
	}

	def comMaximo(maximo: BigDecimal) = {
		this.maximo = maximo;
		this
	}



	def comVolume(volume:BigDecimal) = {
		this.volume = volume
		this
	}

	def comData(data:LocalDateTime) = {
		this.data = data
		this
	}

	def geraCandle() = Candlestick(abertura,fechamento,minimo,maximo,volume,data)
}