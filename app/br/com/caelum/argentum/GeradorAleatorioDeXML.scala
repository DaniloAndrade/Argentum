package br.com.caelum.argentum

import java.time.{LocalDateTime, Month, ZoneOffset}
import java.util.Date

import br.com.caelum.argentum.modelo.Negociacao

import scala.util.Random
import scala.xml.Node

/**
	* Created by danilo on 22/05/16.
	*/
object GeradorAleatorioDeXML extends App {

	val random = Random

	val negociacoes = gerarDias(30,Month.JANUARY).map(geraListaNegociosParaDia(_))
		    .reduce((l1,l2) => l1:::l2)
	salvarXml(gerarXml(negociacoes))



	def geraListaNegociosParaDia(data: LocalDateTime): List[Negociacao] = {
		val quantidadeNegociosDia = random.nextInt(20)


		def geraValor() = {
			val valor = (random.nextInt(200) - 100) / 100.0
			if (valor < 5.0) 5.0 else valor
		}

		def geraQuantidade() = {
			500 + random.nextInt(1000)
		}

		(0 to quantidadeNegociosDia).map(v => {
			Negociacao(geraValor(), geraQuantidade(), data)
		}).toList
	}

	def gerarDias(dias: Int, mes: Month) = (1 to dias)
		.map(dia => LocalDateTime.of(2016, mes, dia, 0, 0))

	def gerarXml(negociacoes: List[Negociacao]) = {
		<list>
			{negociacoes.map(n => {
			<negociacao>
				<preco>
					{n.preco}
				</preco>
				<quantidade>
					{n.quantidade}
				</quantidade>
				<data>
					<time>{toMillis(n.data)}</time>
				</data>
			</negociacao>
		})}
		</list>
	}

	def salvarXml(xml: Node): Unit = {
		scala.xml.XML.save("negociacoes.xml", xml, "UTF-8")
	}


	def toMillis(data: LocalDateTime): Long = {
		val instant = data.toInstant(ZoneOffset.UTC)
		val dataComoDate = Date.from(instant)
		dataComoDate.getTime
	}
}
