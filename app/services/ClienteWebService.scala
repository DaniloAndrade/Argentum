package services

import br.com.caelum.argentum.modelo.Negociacao
import br.com.caelum.argentum.reader.LeitorXML

import scala.io.Source
import scala.util.{Failure, Success, Try}
import scala.xml.XML

/**
	* Created by danilo on 23/05/16.
	*/
object ClienteWebService {
	val URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes"

	def negociacoes:List[Negociacao] = {
		Try(Source.fromURL(URL_WEBSERVICE).bufferedReader()) match {
			case Success(reader) => new LeitorXML().carregaFromXml(XML.load(reader))
			case Failure(f) => {
				println(f)
				Nil
			}
		}
	}
}
