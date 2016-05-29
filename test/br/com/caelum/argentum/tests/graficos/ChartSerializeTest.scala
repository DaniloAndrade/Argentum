package br.com.caelum.argentum.tests.graficos

import br.com.caelum.argentum.graficos._
import br.com.caelum.argentum.graficos.Layout._
import br.com.caelum.argentum.graficos.VerticalAlign._
import br.com.caelum.argentum.graficos.Chart._
import org.specs2.mutable.Specification
import play.api.libs.json.Json

/**
	* Created by danilo on 29/05/16.
	*/
class ChartSerializeTest extends Specification{

	val jsonLegend =
		"""|{
			|  "layout" : "vertical",
			|  "align" : "right",
			|  "verticalAlign" : "middle",
			|  "borderWidth" : 0
			|}""".stripMargin

	val jsonPlotline =
		"""|{
			|  "value" : 0,
			|  "width" : 1,
			|  "color" : "#808080"
			|}""".stripMargin

	val jsonChart =
		"""{
			|  "title" : {
			|    "text" : "Titulo",
			|    "x" : -20
			|  },
			|  "subtitle" : {
			|    "text" : "SubTitulo",
			|    "x" : -20
			|  },
			|  "xAxis" : {
			|    "categories" : [ "1/2016", "2/2016", "3/2016" ]
			|  },
			|  "yAxis" : {
			|    "title" : {
			|      "text" : "R$",
			|      "x" : -20
			|    },
			|    "plotLines" : [ {
			|      "value" : 0,
			|      "width" : 1,
			|      "color" : "#808080"
			|    } ]
			|  },
			|  "tooltip" : {
			|    "valuePrefix" : "R$",
			|    "valueSuffix" : ""
			|  },
			|  "legend" : {
			|    "layout" : "vertical",
			|    "align" : "right",
			|    "verticalAlign" : "middle",
			|    "borderWidth" : 0
			|  },
			|  "series" : [ {
			|    "name" : "MMS",
			|    "data" : [ 10, 15.5, 5.9 ]
			|  } ]
			|}""".stripMargin

	val jsonChartSemValOps =
		"""{
			|  "title" : { },
			|  "subtitle" : { },
			|  "xAxis" : { },
			|  "yAxis" : { },
			|  "tooltip" : { },
			|  "legend" : { },
			|  "series" : [ {
			|    "name" : "MMS",
			|    "data" : [ 10, 15.5, 5.9 ]
			|  } ]
			|}""".stripMargin



	"Uma Legend " >> {
		val legend = Legend(vertical,Align.right,middle,0)
		val json = Json.toJson(legend)
		"dever gerar json valido" >> {
			Json.prettyPrint(json) must_==  jsonLegend
		}

	}

	"Uma Plotline " >> {
		//val legend = Legend(vertical,Align.right,middle,0)
		val plotline = PlotLineValues(0,1,"#808080")
		val json = Json.toJson(plotline)
		"dever gerar json valido" >> {
			Json.prettyPrint(json) must_==  jsonPlotline
		}

	}

	"Um Chart" >> {
		val titleOps = Option(Title("Titulo"))
		val subTitleOps = Option(SubTitle("SubTitulo"))
		val xAxisOps = Option(XAxis(List("1/2016","2/2016","3/2016")))
		val yAxisOps = Option(YAxis(Title("R$"),List(PlotLineValues(0,1,"#808080"))))
		val tooltipOps = Option(Tooltip("R$"))
		val legendOps = Option(Legend(vertical,Align.right,VerticalAlign.middle,0))
		val series = List(LineSerie("MMS", List(BigDecimal(10.0),BigDecimal(15.5),BigDecimal(5.9))))
		val chart = Chart(titleOps,subTitleOps,xAxisOps,yAxisOps,tooltipOps,legendOps,series)
		val json = Json.toJson(chart)
		"deve gerar json valido" >> {
			Json.prettyPrint(json) must_== jsonChart
		}

		"deve gerar json valido sem valores opcionais" >> {
			val chart2 = Chart(series=series)
			val json2 = Json.toJson(chart2)
			Json.prettyPrint(json2) must_== jsonChartSemValOps
		}
	}
}
