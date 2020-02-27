package Authentication

import com.google.inject.Inject
import controllers.routes
import models.LoginDetails
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class AuthenticatedRequest[A](val username: String, request: Request[A]) extends WrappedRequest[A](request)

class UserAction @Inject() (val parser: BodyParsers.Default)(implicit val executionContext: ExecutionContext)
  extends ActionBuilder[AuthenticatedRequest, AnyContent]
  with ActionTransformer[Request, AuthenticatedRequest] {

  def transform[A](request: Request[A]) = Future.successful {
    request.session.get("username")
      .map(LoginDetails.checkUser(_))
      .map(userDetails => new AuthenticatedRequest(userDetails, request))
      .getOrElse(Future.successful("/login"))
  }

}

//class AuthenticatedRequest[A](val username: String, val request: Request[A]) extends WrappedRequest[A](request)
//
//object AuthenticatedAction extends ActionBuilder[AuthenticatedRequest] with Controller {
//  def invokeBlock[A](request: Request[A], block: AuthenticatedRequest[A] => Future[Result]): Future[Result] = {
//    request.session.get("username")
//      .map(LoginDetails.checkUser(_))
//      .map(value => block(new AuthenticatedRequest(value, request)))
//      .getOrElse(Future.successful(Redirect(routes.LoginController.login())))
//  }
//}