package br.com.caelum.argentum.graficos

import br.com.caelum.argentum.graficos.TypeSerie.TypeSerie
import play.api.libs.json.{JsValue, Json, Writes}

/**
	* Created by danilo on 02/06/16.
	*/
class Serie(val name:String, val tipo:TypeSerie, val data:List[BigDecimal]) {

}

object Serie {
	implicit val implicitSerieWrites = new Writes[Serie] {
		override def writes(s: Serie): JsValue = {
			Json.obj(
				"type" -> s.tipo,
				"name" -> s.name,
				"data" -> Json.toJson(s.data)
			)
		}
	}
}

object TypeSerie extends Enumeration{
	type TypeSerie = Value

	val column = Value("column")
	val spline = Value("spline")
	val line = Value("line")
	val pie = Value("pie")

}
