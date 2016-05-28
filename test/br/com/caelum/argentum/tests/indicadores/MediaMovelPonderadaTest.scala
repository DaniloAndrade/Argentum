package br.com.caelum.argentum.tests.indicadores

import br.com.caelum.argentum.indicadores.MediaMovelPonderada
import br.com.caelum.argentum.modelo.SerieTemporal
import org.specs2.mutable.Specification

/**
	* Created by danilo on 27/05/16.
	*/
class MediaMovelPonderadaTest extends Specification {

	"Para uma sequencia simples de candles " >> {
		val serie: SerieTemporal = GeradoreDeSerie(1, 2, 3, 4, 5, 6)

		val mmp = new MediaMovelPonderada

		"o calcula para 2 deve ser : 1*1 + 2*2 +3*3 = 14. Divide por 6, da 14/6 " >> {
			mmp.calcula(2, serie).toDouble must beCloseTo(14.0 / 6, 0.00001)
		}

		"o calcula para 3 deve ser: 2*1 + 3*2 + 4*3 = 20. Divide por 6, da 20/6  " >> {
			mmp.calcula(3, serie).toDouble must beCloseTo(20.0 / 6, 0.00001)
		}

		"o calcula para 4 deve ser: 3*1 + 4*2 + 5*3 = 26. Divide por 6, da 26/6 " >> {
			mmp.calcula(4, serie).toDouble must beCloseTo(26.0 / 6, 0.00001)
		}

		"o calcula para 5 deve ser: 4*1 + 5*2 + 6*3 = 32. Divide por 6, da 32/6 " >> {
			mmp.calcula(5, serie).toDouble must beCloseTo(32.0 / 6, 0.00001)
		}
	}
}
