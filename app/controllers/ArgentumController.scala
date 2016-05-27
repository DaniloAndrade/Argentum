package controllers

import javax.inject.{Inject, Singleton}

import br.com.caelum.argentum.modelo.Negociacao
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
}
