package br.com.caelum.argentum.modelo

import br.com.caelum.argentum.graficos.{PlotLineValues, Tooltip, _}
import br.com.caelum.argentum.indicadores.{Indicador, MediaMovelSimples}
import br.com.caelum.argentum.Formatters._
import br.com.caelum.argentum.PieSerie

/**
	* Created by danilo on 28/05/16.
	*/
class GeradorModeloGrafico(val temporalSerie:SerieTemporal, val inicio:Int, val fim:Int, titulo:String) {

	val intervalo = inicio to fim



	def chartBuilder(_titulo: String, list: List[Serie]): Chart = {
		val xAxis = XAxis(categorias)
		//val yAxis = YAxis(Title("R$", 0), List(PlotLineValues(0, 2, "#808080")))
		val yAxis = YAxis(Title("R$", 0),List())
		val tooltip = Tooltip("R$")
		val titulo = Title(_titulo)
		val chart = Chart(
			series = list,
			xAxis = Option(xAxis),
			yAxis = Option(yAxis),
			title = Option(titulo),
			tooltip = Option(tooltip))
		chart
	}

	def plotaIndicador(indicador: Indicador, calc: Indicador => List[BigDecimal])(f: (String ,List[BigDecimal]) => List[Serie] ):Chart = {
		chartBuilder(titulo, f(indicador.toString,calc(indicador)))
	}


	def calcular(indicador: Indicador) = intervalo.map(indice => indicador.calcula(indice,temporalSerie)).toList

	def plotaIndicadorInLineChart(indicador: Indicador) = plotaIndicador(indicador,calcular) { (legenda:String, valores:List[BigDecimal]) =>
		List(LineSerie(legenda,valores))
	}

	def plotaIndicadorInColumnChart(indicador: Indicador) = plotaIndicador(indicador,calcular) { (legenda:String, valores:List[BigDecimal]) =>
		List(ColumnSerie(legenda,valores))
	}

	def plotaIndicadorInCombinationLineColumnChart(indicador: Indicador) = plotaIndicador(indicador,calcular) { (legenda:String, valores:List[BigDecimal]) =>
		List(LineSerie(legenda,valores),ColumnSerie(legenda,valores))
	}

	def categorias = intervalo map(inicio => temporalSerie.candle(inicio).data) map(_.formatTo("dd/MM/yyyy")) toList

}

