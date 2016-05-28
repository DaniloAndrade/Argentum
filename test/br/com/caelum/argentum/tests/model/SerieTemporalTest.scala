package br.com.caelum.argentum.tests.model

import br.com.caelum.argentum.modelo.SerieTemporal
import org.specs2.mutable.Specification

/**
	* Created by danilo on 28/05/16.
	*/
class SerieTemporalTest extends Specification{

	"Um SerieTemporal " >> {

		"Não pode ser criada com Lista vazia " >> {

			SerieTemporal(List()) must throwA[IllegalArgumentException]
		}
	}
}
