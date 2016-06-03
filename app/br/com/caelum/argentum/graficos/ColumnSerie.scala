package br.com.caelum.argentum.graficos

import play.api.libs.json.{JsValue, Json, Writes}

/**
	* Created by danilo on 02/06/16.
	*/
case class ColumnSerie(override val name:String, override val data:List[BigDecimal]) extends Serie(name,TypeSerie.column,data)

