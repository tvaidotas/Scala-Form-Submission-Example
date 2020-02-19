package controllers

import javax.inject._
import models.CD
import play.api.mvc._

@Singleton
class CDController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {

  def showCDForm() = Action { implicit request: Request[AnyContent] =>
    Ok("Nothing to see yet")
  }

  def submitCD = Action { implicit request: Request[AnyContent] =>
    Ok("Nothing to return yet")
  }

}
