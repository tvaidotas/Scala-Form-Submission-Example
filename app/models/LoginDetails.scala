package models

case class LoginDetails(username: String, password: String)

object LoginDetails {

  def checkCredentials(loginDetails: LoginDetails): Boolean = {
    if (loginDetails.username == "admin" && loginDetails.password == "admin")
      true
    else
      false
  }

  def checkUser(loginDetails: String): String = {
    if (loginDetails == "admin")
      "admin"
    else
      ""
  }

}
