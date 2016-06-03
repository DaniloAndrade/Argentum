package br.com.caelum.argentum

import br.com.caelum.argentum.graficos.{Serie, TypeSerie}

/**
	* Created by danilo on 02/06/16.
	*/
case class PieSerie(override val name:String, override val data:List[BigDecimal]) extends Serie(name,TypeSerie.pie,data)