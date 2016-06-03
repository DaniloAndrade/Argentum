package br.com.caelum.argentum.graficos

import play.api.libs.json.{JsValue, Json, Writes}

/**
	* Created by danilo on 28/05/16.
	*/
case class LineSerie(override val name:String, override val data:List[BigDecimal]) extends Serie(name,TypeSerie.line,data)



//object LineSerie{
//
//	implicit val implicitNegocicaoWrites = new Writes[LineSerie] {
//		override def writes(l: LineSerie): JsValue = {
//			Json.obj(
//				"type" -> l.tipo,
//				"name" -> l.name,
//				"data" -> Json.toJson(l.data)
//			)
//		}
//	}
//}
