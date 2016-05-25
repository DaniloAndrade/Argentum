package br.com.caelum.argentum.tests.model

import java.time.LocalDateTime

import br.com.caelum.argentum.modelo.Negociacao
import org.specs2.mutable.Specification

/**
	* Created by danilo on 16/05/16.
	*/
class NegociacaoTest extends Specification{

	"Uma Negociaçao" >> {

		"não pode ser criado com quantidade negativa" >> {
			Negociacao(49.0,-10,LocalDateTime.now()) must throwA[IllegalArgumentException]
		}

		"não pode ser criado com data nulla" >> {
			Negociacao(49.0,100,null) must throwA[IllegalArgumentException]
		}

		"Criada não deve ser possivel alterar sua data" >> {
			val negociacao = Negociacao(49.0,100,LocalDateTime.of(2016,1,25,10,10,10))
			negociacao.data.minusDays(20)
			negociacao.data.getDayOfMonth must_== 25
		}

		"Será do mesmo dia se dia, mes e ano forem iguais" >> {
			val negociacao = Negociacao(49.0,100,LocalDateTime.of(2016,1,25,10,10,10))
			val data = LocalDateTime.of(2016,1,25,23,10,10)
			negociacao.isMesmoDia(data) must_== true
		}
	}
}
