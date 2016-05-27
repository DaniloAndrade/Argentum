package br.com.caelum.argentum

import java.text.NumberFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
	* Created by danilo on 26/05/16.
	*/

object Formatters {

	implicit def toRichBigDecimal(value:BigDecimal) = new RichBigDecimal(value)
	implicit def toRichLocalDateTime(value:LocalDateTime) = new RichLocalDateTime(value)
}

class RichBigDecimal(val value:BigDecimal){
	def toCurrencyFormat = NumberFormat.getCurrencyInstance.format(value)
}

class RichLocalDateTime(val value:LocalDateTime){
	def formatTo = {
		val dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
		value.format(dateTimeFormat)
	}

	def formatTo(pattern:String) = {
		val dateTimeFormat = DateTimeFormatter.ofPattern(pattern)
		value.format(dateTimeFormat)
	}
}

