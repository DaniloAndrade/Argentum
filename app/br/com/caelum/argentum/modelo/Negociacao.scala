package br.com.caelum.argentum.modelo

import java.time.LocalDateTime

/**
	* Created by danilo on 15/05/16.
	*/
case class Negociacao(val preco:BigDecimal,val quantidade:Int, val data:LocalDateTime ) {

	require(quantidade >= 0 )
	require(data != null)


	def isMesmoDia(outraData:LocalDateTime) = {
		data.getDayOfMonth == outraData.getDayOfMonth &&
		data.getMonth == outraData.getMonth &&
		data.getYear == outraData.getYear
	}

	def volume = preco * quantidade
}
