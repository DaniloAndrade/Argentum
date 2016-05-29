package br.com.caelum.argentum.graficos

import play.api.libs.json.{JsValue, Json, Writes}

/**
	* Created by danilo on 28/05/16.
	*/
case class LineSerie(val nome:String, val data:List[BigDecimal])


object LineSerie{

	implicit val implicitNegocicaoWrites = new Writes[LineSerie] {
		override def writes(l: LineSerie): JsValue = {
			Json.obj(
				"name" -> l.nome,
				"data" -> Json.toJson(l.data)
			)
		}
	}
}
