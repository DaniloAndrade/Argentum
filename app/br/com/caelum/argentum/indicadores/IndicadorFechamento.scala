package br.com.caelum.argentum.indicadores
import br.com.caelum.argentum.modelo.SerieTemporal

/**
	* Created by danilo on 31/05/16.
	*/
class IndicadorFechamento extends Indicador{
	override def calcula(posicao: Int, serie: SerieTemporal): BigDecimal = {
		serie.candle(posicao).fechamento
	}


	override def toString = "Fechamento"
}
