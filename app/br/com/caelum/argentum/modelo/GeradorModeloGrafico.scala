package br.com.caelum.argentum.modelo

import br.com.caelum.argentum.graficos.LineSerie
import br.com.caelum.argentum.indicadores.{Indicador, MediaMovelSimples}
import br.com.caelum.argentum.Formatters._

/**
	* Created by danilo on 28/05/16.
	*/
class GeradorModeloGrafico(val serie:SerieTemporal, val inicio:Int, val fim:Int) {
	def plotaIndicador(indicador: Indicador) = {
		val valores = (inicio to fim).map(indice => indicador.calcula(indice,serie)).toList
		LineSerie(indicador.toString, valores)
	}

	def categorias = (inicio to fim) map(inicio => serie.candle(inicio).data) map(_.formatTo("dd/MM/yyyy")) toList

}
