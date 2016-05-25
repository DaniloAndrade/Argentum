package br.com.caelum.argentum.tests.model

import java.time.LocalDateTime

import br.com.caelum.argentum.modelo.{Candlestick, Negociacao}
import org.specs2.mutable.Specification

/**
	* Created by danilo on 17/05/16.
	*/
class CandlestickTest extends Specification{

	"Um Candlestick valido" >> {
		"não deve ter o preço maximo menor que o minimo" >> {
			Candlestick(10.1,20.5,25.0,9.0,100,LocalDateTime.now()) must throwA[IllegalArgumentException]

		}
	}

	"Um Candlestick abertura 10.1 e fechamento 10.1 " >> {
		val candle = Candlestick(10.1,10.1,2.2,9.0,100,LocalDateTime.now())
		"deve ser de alta" >> {
			candle.isAlta must_== true
		}
	}

}
