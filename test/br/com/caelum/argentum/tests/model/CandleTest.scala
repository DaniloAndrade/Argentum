package br.com.caelum.argentum.tests.model

import java.time.LocalDateTime

import br.com.caelum.argentum.modelo.{Candle, Negociacao}
import org.specs2.mutable.Specification

/**
	* Created by danilo on 17/05/16.
	*/
class CandleTest extends Specification{

	"Um Candlestick valido" >> {
		"não deve ter o preço maximo menor que o minimo" >> {
			Candle(10.1,20.5,25.0,9.0,100,LocalDateTime.now()) must throwA[IllegalArgumentException]

		}
	}

	"Um Candlestick abertura 10.1 e fechamento 10.1 " >> {
		val candle = Candle(10.1,10.1,2.2,9.0,100,LocalDateTime.now())
		"deve ser de alta" >> {
			candle.isAlta must_== true
		}
	}

}
