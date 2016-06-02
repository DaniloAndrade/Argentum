package br.com.caelum.argentum.modelo

import br.com.caelum.argentum.graficos.{PlotLineValues, Tooltip, _}
import br.com.caelum.argentum.indicadores.{Indicador, MediaMovelSimples}
import br.com.caelum.argentum.Formatters._

/**
	* Created by danilo on 28/05/16.
	*/
class GeradorModeloGrafico(val serie:SerieTemporal, val inicio:Int, val fim:Int, titulo:String) {
	def plotaIndicador(indicador: Indicador) = {
		val valores = (inicio to fim).map(indice => indicador.calcula(indice,serie)).toList
		chartFactory(titulo,LineSerie(indicador.toString, valores),categorias)
	}


	def chartFactory(_titulo:String, lineSerie: LineSerie, categorias: List[String]): Chart = {
		val xAxis = XAxis(categorias)
		val yAxis = YAxis(Title("R$", 0), List(PlotLineValues(0, 2, "#808080")))
		val tooltip = Tooltip("R$")
		val titulo = Title(_titulo)
		val chart = Chart(
			series = List(lineSerie),
			xAxis = Option(xAxis),
			yAxis = Option(yAxis),
			title = Option(titulo),
			tooltip = Option(tooltip))
		chart
	}

	def categorias = (inicio to fim) map(inicio => serie.candle(inicio).data) map(_.formatTo("dd/MM/yyyy")) toList

}
