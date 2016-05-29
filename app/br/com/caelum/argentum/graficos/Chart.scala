package br.com.caelum.argentum.graficos

import br.com.caelum.argentum.graficos.Align.Align
import br.com.caelum.argentum.graficos.LineSerie._
import br.com.caelum.argentum.graficos.Layout.Layout
import br.com.caelum.argentum.graficos.VerticalAlign.VerticalAlign
import play.api.libs.json.{JsValue, Json, Writes}

/**
	* Created by danilo on 29/05/16.
	*/
case class Chart(val title:Option[Title] = None,
								 val subtitle:Option[SubTitle] = None,
								 val xAxis:Option[XAxis] = None,
								 val yAxis:Option[YAxis] = None,
								 val tooltip:Option[Tooltip] = None,
								 val legend:Option[Legend] = None,
								 val series:List[LineSerie] = List.empty) {

}



object Chart {

	implicit val writerLegend = new Writes[Legend] {
		override def writes(legend: Legend): JsValue = {
			Json.obj(
				"layout" -> legend.layout,
				"align" -> legend.align,
				"verticalAlign" -> legend.verticalAlign,
				"borderWidth" -> legend.borderWidth
			)
		}
	}

	implicit val writeLegendOps = new Writes[Option[Legend]] {
		override def writes(o: Option[Legend]): JsValue = o match {
			case None => Json.obj()
			case Some(legend) => Json.obj(
				"layout" -> legend.layout,
				"align" -> legend.align,
				"verticalAlign" -> legend.verticalAlign,
				"borderWidth" -> legend.borderWidth
			)
		}
	}

	implicit val writerPlotLine = new Writes[PlotLineValues] {
		override def writes(plotline: PlotLineValues): JsValue = {
			Json.obj(
				"value" -> plotline.value,
				"width" -> plotline.width,
				"color" -> plotline.color
			)
		}
	}


	implicit val writeTitleOps = new Writes[Option[Title]] {
		override def writes(o: Option[Title]): JsValue = o match {
			case None => Json.obj()
			case Some(title) => Json.obj(
				"text" -> title.text,
				"x" -> title.x
			)
		}
	}


	implicit val writerTitle = new Writes[Title] {
		override def writes(title: Title): JsValue = Json.obj(
			"text" -> title.text,
			"x" -> title.x
		)
	}

	implicit val writerSubTitle = new Writes[SubTitle] {
		override def writes(subTitle: SubTitle): JsValue = Json.obj(
			"text" -> subTitle.text,
			"x" -> subTitle.x
		)
	}

	implicit val writeSubTitleOps = new Writes[Option[SubTitle]] {
		override def writes(o: Option[SubTitle]): JsValue = o match {
			case None => Json.obj()
			case Some(title) => Json.obj(
				"text" -> title.text,
				"x" -> title.x
			)
		}
	}

	implicit val writerXAxis = new Writes[XAxis] {
		override def writes(xAxis: XAxis): JsValue = Json.obj(
			"categories" -> Json.toJson(xAxis.categories)
		)
	}

	implicit val writerXAxisOps = new Writes[Option[XAxis]] {
		override def writes(o: Option[XAxis]): JsValue = o match {
			case None => Json.obj()
			case Some(xAxis) => Json.obj(
				"categories" -> Json.toJson(xAxis.categories)
			)
		}
	}


	implicit val writerYAxis = new Writes[YAxis] {
		override def writes(yAxis: YAxis): JsValue = Json.obj(
			"title" -> yAxis.title,
			"plotLines" -> Json.toJson(yAxis.plotLines)
		)
	}


	implicit val writerYAxisOps = new Writes[Option[YAxis]] {
		override def writes(o: Option[YAxis]): JsValue = o match {
			case None => Json.obj()
			case Some(yAxis) => Json.obj(
				"title" -> yAxis.title,
				"plotLines" -> Json.toJson(yAxis.plotLines)
			)
		}
	}

	implicit val writerTooltip = Json.writes[Tooltip]

	implicit val writerTooltipOps = new Writes[Option[Tooltip]] {
		override def writes(o: Option[Tooltip]): JsValue = o match {
			case None => Json.obj()
			case Some(tooltip) => Json.obj(
				"valuePrefix" -> tooltip.valuePrefix,
				"valueSuffix" -> tooltip.valueSuffix
			)
		}
	}


		implicit val writerChart =  new Writes[Chart] {
		override def writes(chart: Chart): JsValue = Json.obj(
				"title" -> chart.title,
				"subtitle" -> chart.subtitle,
				"xAxis" -> chart.xAxis,
				"yAxis" -> chart.yAxis,
				"tooltip" -> chart.tooltip,
				"legend" -> chart.legend,
				"series" -> chart.series

			)

	}
}

case class Title(val text:String,val x:Int = -20)

case class SubTitle(val text:String, val x:Int = -20)

case class XAxis(val categories:List[String])

case class YAxis(val title:Title, val plotLines:List[PlotLineValues] = List.empty)

case class Tooltip(val valuePrefix:String = "", val valueSuffix:String="")

case class Legend(val layout:Layout, val align: Align,
									val verticalAlign: VerticalAlign, val borderWidth:Int )

case class PlotLineValues(val value:Int, val width:Int, val color:String)


object Layout extends Enumeration{
	type Layout = Value

	val vertical = Value
}

object Align extends Enumeration{
	type Align = Value

	val right, left = Value
}

object VerticalAlign extends Enumeration{
	type VerticalAlign = Value

	val middle = Value
}









