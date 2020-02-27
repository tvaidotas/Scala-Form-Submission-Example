package models

case class User(username: String)

object User {

  val userList = List(User("Tadas"))

  def findByUsername(username: String) = {
    userList.find(user => user.username == username).getOrElse("User not found")
  }

}