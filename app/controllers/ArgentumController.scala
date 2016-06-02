package controllers

import javax.inject.{Inject, Singleton}

import br.com.caelum.argentum.graficos._
import br.com.caelum.argentum.graficos.Chart._
import br.com.caelum.argentum.indicadores.{IndicadorFechamento, Indicadores, MediaMovelSimples}
import br.com.caelum.argentum.modelo._
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json.{JsValue, Json, Writes}
import play.api.mvc.{Action, Controller}
import services.ClienteWebService

/**
	* Created by danilo on 25/05/16.
	*/


@Singleton
class ArgentumController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport{

	implicit val implicitNegocicaoWrites = new Writes[Negociacao] {
		override def writes(o: Negociacao): JsValue = {
			Json.obj(
				"preco" -> o.preco,
				"quantidade" -> o.quantidade,
				"data" -> o.data.toString
			)
		}
	}


	def listaNegociacoes = Action {
		val json = Json.toJson(ClienteWebService.negociacoes)
		Ok(json)
	}

	def listar = Action {
		Ok(views.html.argentum(ClienteWebService.negociacoes))
	}

	def mediaMovelSimples = Action{
		val negociacoes = ClienteWebService.negociacoes
		val candles = CandleFactory.constroiCandles(negociacoes)
		val serieTemporal = SerieTemporal(candles)
		val gerador = new GeradorModeloGrafico(serieTemporal,2,serieTemporal.ultimaPosicao, "Indicadores")
		val chart = gerador.plotaIndicador(new MediaMovelSimples(3,new IndicadorFechamento))
		val json = Json.toJson(chart)
		Ok(json).as("text/json")
	}


	def geraGrafico(indicadorBase:String, indicadorMedia:String) = Action {
		val base = Indicadores.criar(indicadorBase)
		val media = Indicadores.criarIndicadorComposto(indicadorMedia)(3,base)
		val negociacoes = ClienteWebService.negociacoes
		val candles = CandleFactory.constroiCandles(negociacoes)
		val serieTemporal = SerieTemporal(candles)
		val gerador = new GeradorModeloGrafico(serieTemporal,2,serieTemporal.ultimaPosicao,"Indicadores")
		val chart = gerador.plotaIndicador(media)
		val json = Json.toJson(chart)
		Ok(json).as("text/json")
	}
}
