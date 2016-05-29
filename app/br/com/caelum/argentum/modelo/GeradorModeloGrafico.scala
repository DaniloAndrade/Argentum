package br.com.caelum.argentum.modelo

import br.com.caelum.argentum.graficos.LineSerie
import br.com.caelum.argentum.indicadores.MediaMovelSimples
import br.com.caelum.argentum.Formatters._

/**
	* Created by danilo on 28/05/16.
	*/
class GeradorModeloGrafico(val serie:SerieTemporal, val inicio:Int, val fim:Int) {
	def plotaMediaMovelSimples = {
		val mms = new MediaMovelSimples

		val valores = (inicio to fim).map(indice => mms.calcula(indice,serie)).toList
		LineSerie("MMS  Fechamento", valores)
	}

	def categorias = (inicio to fim) map(inicio => serie.candle(inicio).data) map(_.formatTo("dd/MM/yyyy")) toList

}
