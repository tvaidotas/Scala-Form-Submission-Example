package controllers

import javax.inject._
import models.CD
import play.api.mvc._

@Singleton
class CDController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {

  def showCDForm() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.submitCD(CD.createCDForm))
  }

  def submitCD = Action { implicit request: Request[AnyContent] =>
    CD.createCDForm.bindFromRequest.fold({ formWithErrors =>
      BadRequest(views.html.submitCD(formWithErrors))
    }, { cd =>
      Ok(cd.toString())
    })
  }

}
