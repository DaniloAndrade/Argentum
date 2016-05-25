package br.com.caelum.argentum.tests.reader

import java.io.ByteArrayInputStream

import br.com.caelum.argentum.reader.LeitorXML
import org.specs2.mutable.Specification

/**
	* Created by danilo on 18/05/16.
	*/
class LeitorXMLTest extends Specification{

	val stringXml:String =
		"""
			|<list>
			|	<negociacao>
			| 	<preco>43.5</preco>
			|  	<quantidade>1000</quantidade>
			|   <data>
			|   	<time>1322233344455</time>
			|   </data>
			| </negociacao>
			|</list>
		""".stripMargin

	val xmlDuasNegociacoes:String =
		"""
			|<list>
			|	<negociacao>
			| 	<preco>43.6</preco>
			|  	<quantidade>1000</quantidade>
			|   <data>
			|   	<time>1322233344456</time>
			|   </data>
			| </negociacao>
			| <negociacao>
			| 	<preco>45.5</preco>
			|  	<quantidade>1000</quantidade>
			|   <data>
			|   	<time>1322233344455</time>
			|   </data>
			| </negociacao>
			|</list>
		""".stripMargin

	val xmlDuasNegociacoesEDadosFaltando:String =
		"""
			|<list>
			|	<negociacao>
			| 	<preco>43.6</preco>
			|   <data>
			|   	<time>1322233344456</time>
			|   </data>
			| </negociacao>
			| <negociacao>
			| 	<preco>45.5</preco>
			|  	<quantidade>1000</quantidade>
			|   <data>
			|   	<time>1322233344455</time>
			|   </data>
			| </negociacao>
			|</list>
		""".stripMargin

	val xmlSemNegociacoes:String =
		"""
			|<list>
			|</list>
		""".stripMargin



	"Um LeitorXML deve" >> {
		val leitor = new LeitorXML()
		val xml = scala.xml.XML.load(new ByteArrayInputStream(stringXml.getBytes))
		val negociacoes = leitor.carregaFromXml(xml)

		"ler xml com negociações e gerar uma lista de negociações" >> {
			negociacoes.size must_== 1
		}

		"a negociação da lista deve ter o preço 43.5" >> {
			negociacoes.head.preco must_== 43.5
		}

		"a negociação da lista deve ter a quantidade igual a 1000" >> {
			negociacoes.head.quantidade must_== 1000
		}
	}

	"Um xml com 2 negociações passado para LeitorXML deve " >> {

		val leitor = new LeitorXML()
		val xml = scala.xml.XML.load(new ByteArrayInputStream(xmlDuasNegociacoes.getBytes))
		val negociacoes = leitor.carregaFromXml(xml)

		"gerar uma Lista com 2 negociaçoes " >> {
			negociacoes.size must_== 2
		}

	}

	"Um xml sem negociações passado para LeitorXML deve " >> {
		val leitor = new LeitorXML()
		val xml = scala.xml.XML.load(new ByteArrayInputStream(xmlSemNegociacoes.getBytes))
		val negociacoes = leitor.carregaFromXml(xml)

		"gerar uma lista vazia " >> {
			negociacoes.size must_== 0
		}
	}


	"Um xml com negociações e dados faltando passado para LeitorXML deve " >> {
		val leitor = new LeitorXML()
		val xml = scala.xml.XML.load(new ByteArrayInputStream(xmlDuasNegociacoesEDadosFaltando.getBytes))
		val negociacoes = leitor.carregaFromXml(xml)

		"gerar uma lista apenas com uma negociacao " >> {
			negociacoes.size must_== 1
		}
	}
}
