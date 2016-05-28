package br.com.caelum.argentum.tests.indicadores

import br.com.caelum.argentum.indicadores.MediaMovelSimples
import br.com.caelum.argentum.modelo.SerieTemporal
import org.specs2.mutable.Specification

/**
	* Created by danilo on 27/05/16.
	*/
class MediaMovelSimplesTest extends Specification {

	"Para uma sequencia simples de candles " >> {
		val serie: SerieTemporal = GeradoreDeSerie(1, 2, 3, 4, 3, 4, 5, 4, 3)

		val mms = new MediaMovelSimples

		"o calculo para 2 serie deve ser 2.0 " >> {
			mms.calcula(2, serie).toDouble must beCloseTo(2.0, 0.00001)
		}

		"o calculo para 3 serie deve ser 3.0 " >> {
			mms.calcula(3, serie).toDouble must beCloseTo(3.0, 0.00001)
		}

		"o calculo para 4 serie deve ser 10.0/3 " >> {
			mms.calcula(4, serie).toDouble must beCloseTo(10.0 / 3, 0.00001)
		}

		"o calculo para 5 serie deve ser 11.0/3 " >> {
			mms.calcula(5, serie).toDouble must beCloseTo(11.0 / 3, 0.00001)
		}

		"o calculo para 6 serie deve ser 4.0 " >> {
			mms.calcula(6, serie).toDouble must beCloseTo(4.0, 0.00001)
		}

		"o calculo para 7 serie deve ser 13.0/3 " >> {
			mms.calcula(7, serie).toDouble must beCloseTo(13.0 / 3, 0.00001)
		}

		"o calculo para 8 serie deve ser 4.0 " >> {
			mms.calcula(8, serie).toDouble must beCloseTo(4.0, 0.00001)
		}
	}


}
