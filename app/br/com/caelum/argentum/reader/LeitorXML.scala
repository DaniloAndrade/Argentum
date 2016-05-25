package br.com.caelum.argentum.reader

import java.time.{LocalDateTime, ZoneId}
import java.util.Date

import br.com.caelum.argentum.modelo.Negociacao

/**
	* Created by danilo on 18/05/16.
	*/
class LeitorXML {

	def carregaFromXml(xml: scala.xml.NodeSeq): List[Negociacao] = {

		xml.flatMap(n => n \\ "negociacao")
			.toList.map(n => {
			val preco = Option((n \\ "negociacao" \ "preco").text)
				.filter(v => !v.isEmpty).map(v => BigDecimal(v))
			val quantidade = Option((n \\ "negociacao" \ "quantidade").text)
				.filter(n => !n.isEmpty).map(n => n.toInt)
			val data = Option((n \\ "negociacao" \ "data" \ "time").text)
				.filter(n => !n.isEmpty).map(v => v.trim.toLong)
				.map(m => new Date(m))
				.map(d => LocalDateTime.ofInstant(d.toInstant, ZoneId.systemDefault()))
			(preco, quantidade, data)
		}).filter(v => !(v._1.isEmpty) && !(v._2.isEmpty) && !(v._3.isEmpty) )
		  .map(v => {
				v match {
					case (preco, quantidade, data) => {Negociacao(preco.getOrElse(BigDecimal(0)), quantidade.getOrElse(0), data.getOrElse(null))}
					case _ => Nil
				}
			}).toList.asInstanceOf[List[Negociacao]]
	}
}
