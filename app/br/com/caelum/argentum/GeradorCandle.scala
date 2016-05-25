package br.com.caelum.argentum

import br.com.caelum.argentum.modelo.CandlestickFactory
import services.ClienteWebService

/**
	* Created by danilo on 23/05/16.
	*/
object GeradorCandle extends App{
	CandlestickFactory.constroiCandles(ClienteWebService.negociacoes).foreach(c => println(c))
}
