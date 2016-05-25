package br.com.caelum.argentum.tests.model

import java.time.LocalDateTime

import br.com.caelum.argentum.modelo.{CandlestickFactory, Negociacao}
import org.specs2.mutable.Specification

/**
	* Created by danilo on 16/05/16.
	*/
class CandlestickFactoryTest extends Specification{

	"dada no dia de hoje as negociacoes com valores 40.5, 40.0, 39.8 e 42.3 e todas com 100 negociacoes " >> {
		val hoje = LocalDateTime.now();

		val negociacao1 = Negociacao(40.5,100,hoje)
		val negociacao2 = Negociacao(45.0,100,hoje)
		val negociacao3 = Negociacao(39.8,100,hoje)
		val negociacao4 = Negociacao(42.3,100,hoje)
		val negociacoes = List(negociacao1,negociacao2,negociacao3,negociacao4)
		val candle = CandlestickFactory.constroiCandleParaData(hoje,negociacoes)

		" o candle gerado deve ter uma abertura 40.5 " >> {
			candle.abertura must_== 40.5
		}

		"o candle gerado deve ter uma fechamento 42.3 " >> {
			candle.fechamento must_== 42.3
		}

		"o candle gerado deve ter uma mínimo 39.8 " >> {
			candle.minimo must_== 39.8
		}

		"o candle gerado deve ter uma máximo 45.0  " >> {
			candle.maximo must_== 45.0
		}

		"o candle gerado deve ter uma volume 16760.0  " >> {
			candle.volume must_== 16760.0
		}
	}

	"dada no dia de hoje as negociacoes com valores crescentes 39.8, 40.5, 42.3 e 45.0  e todas com 100 negociacoes " >> {
		val hoje = LocalDateTime.now();

		val negociacao1 = Negociacao(39.8,100,hoje)
		val negociacao2 = Negociacao(40.5,100,hoje)
		val negociacao3 = Negociacao(42.3,100,hoje)
		val negociacao4 = Negociacao(45.0,100,hoje)
		val negociacoes = List(negociacao1,negociacao2,negociacao3,negociacao4)
		val candle = CandlestickFactory.constroiCandleParaData(hoje,negociacoes)

		" o candle gerado deve ter uma abertura 39.8 " >> {
			candle.abertura must_== 39.8
		}

		"o candle gerado deve ter uma fechamento 45.0 " >> {
			candle.fechamento must_== 45.0
		}

		"o candle gerado deve ter uma mínimo 39.8 " >> {
			candle.minimo must_== 39.8
		}

		"o candle gerado deve ter uma máximo 45.0  " >> {
			candle.maximo must_== 45.0
		}

		"o candle gerado deve ter uma volume 16760.0  " >> {
			candle.volume must_== 16760.0
		}

		"o candle gerado deve ser de alta " >> {
			candle.isAlta must_== true
		}
	}

	"dada no dia de hoje as negociacoes com valores decrescentes 45.0, 42.3, 40.5 e  39.8 e todas com 100 negociacoes " >> {
		val hoje = LocalDateTime.now();

		val negociacao1 = Negociacao(45.0,100,hoje)
		val negociacao2 = Negociacao(42.3,100,hoje)
		val negociacao3 = Negociacao(40.5,100,hoje)
		val negociacao4 = Negociacao(39.8,100,hoje)
		val negociacoes = List(negociacao1,negociacao2,negociacao3,negociacao4)
		val candle = CandlestickFactory.constroiCandleParaData(hoje,negociacoes)

		" o candle gerado deve ter uma abertura 45.0 " >> {
			candle.abertura must_== 45.0
		}

		"o candle gerado deve ter uma fechamento 39.8 " >> {
			candle.fechamento must_== 39.8
		}

		"o candle gerado deve ter uma mínimo 39.8 " >> {
			candle.minimo must_== 39.8
		}

		"o candle gerado deve ter uma máximo 45.0  " >> {
			candle.maximo must_== 45.0
		}

		"o candle gerado deve ter uma volume 16760.0  " >> {
			candle.volume must_== 16760.0
		}

		"o candle gerado deve ser de baixa " >> {
			candle.isBaixa must_== true
		}
	}


	"dada no dia de hoje apena uma negociacão com valor 40.5 e toda com 100 negociacao " >> {
		val hoje = LocalDateTime.now();

		val negociacao1 = Negociacao(40.5,100,hoje)
		val negociacoes = List(negociacao1)
		val candle = CandlestickFactory.constroiCandleParaData(hoje,negociacoes)

		" o candle gerado deve ter uma abertura 40.5 " >> {
			candle.abertura must_== 40.5
		}

		"o candle gerado deve ter uma fechamento 40.5 " >> {
			candle.fechamento must_== 40.5
		}

		"o candle gerado deve ter uma mínimo 40.5 " >> {
			candle.minimo must_== 40.5
		}

		"o candle gerado deve ter uma máximo 40.5  " >> {
			candle.maximo must_== 40.5
		}

		"o candle gerado deve ter uma volume 4050.0  " >> {
			candle.volume must_== 4050.0
		}
	}

	"dada que no dia de hoje não houve negociações  " >> {
		val hoje = LocalDateTime.now();

		val negociacoes:List[Negociacao] = List()
		val candle = CandlestickFactory.constroiCandleParaData(hoje,negociacoes)

		"o candle gerado deve ter uma abertura 0.0 " >> {
			candle.abertura must_== 0.0
		}

		"o candle gerado deve ter uma fechamento 0.0 " >> {
			candle.fechamento must_== 0.0
		}

		"o candle gerado deve ter uma mínimo 0.0 " >> {
			candle.minimo must_== 0.0
		}

		"o candle gerado deve ter uma máximo 0.0  " >> {
			candle.maximo must_== 0.0
		}

		"o candle gerado deve ter uma volume 4050.0  " >> {
			candle.volume must_== 0.0
		}
	}


	"Dado uma lista com 3 negociações de dias " >> {
		val hoje = LocalDateTime.now();

		val negociacao1 = Negociacao(40.5,100,hoje)
		val negociacao2 = Negociacao(45.0,100,hoje)
		val negociacao3 = Negociacao(39.8,100,hoje)
		val negociacao4 = Negociacao(42.3,100,hoje)


		val negociacao5 = Negociacao(48.8,100,hoje.plusDays(1))
		val negociacao6 = Negociacao(49.3,100,hoje.plusDays(1))

		val negociacao7 = Negociacao(51.8,100,hoje.plusDays(2))
		val negociacao8 = Negociacao(52.3,100,hoje.plusDays(2))

		val negociacoes = List(negociacao1,negociacao2,negociacao3,
			negociacao4,negociacao5,negociacao6,negociacao7,negociacao8)
		val candles = CandlestickFactory.constroiCandles(negociacoes)


		"deve gerar uma lista de candles com 3 candles " >> {
			candles.size must_== 3
		}

		"o primeiro candle deve ter abertura igual a 40.5" >> {
			candles(0).abertura must_== 40.5
		}

		"o primeiro candle deve ter fechamento igual a 42.3" >> {
			candles(0).fechamento must_== 42.3
		}

		"o segundo candle deve ter abertura igual a 48.8" >> {
			candles(1).abertura must_== 48.8
		}

		"o segundo candle deve ter fechamento igual a 49.3" >> {
			candles(1).fechamento must_== 49.3
		}

		"o terceiro candle deve ter abertura igual a 51.8" >> {
			candles(2).abertura must_== 51.8
		}

		"o terceiro candle deve ter fechamento igual a 52.3" >> {
			candles(2).fechamento must_== 52.3
		}
	}

}
