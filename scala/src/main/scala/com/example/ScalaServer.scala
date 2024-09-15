package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future
import scala.io.StdIn

object ScalaServer extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val db = Database.forConfig("mydb")

  val route = path("data") {
    get {
      onComplete(db.run(sql"SELECT * FROM users".as[(Int, String, String)])) {
        case scala.util.Success(rows) =>
          val response = rows.map { case (id, name, email) => s"ID: $id, Name: $name, Email: $email" }.mkString("\n")
          complete(HttpResponse(entity = response))
        case scala.util.Failure(exception) =>
          complete(HttpResponse(StatusCodes.InternalServerError, entity = exception.getMessage))
      }
    }
  }

  val bindingFuture = Http().newServerAt("localhost", 8081).bind(route)

  println(s"Server online at http://localhost:8081/")
  StdIn.readLine()
  bindingFuture.flatMap(_.unbind()).onComplete(_ => system.terminate())
}
