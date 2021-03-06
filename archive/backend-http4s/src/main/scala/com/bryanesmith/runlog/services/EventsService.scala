package com.bryanesmith.runlog.services

import com.bryanesmith.runlog.dto.User
import com.bryanesmith.runlog.utils
import com.bryanesmith.runlog.utils.Demo
import com.bryanesmith.runlog.utils.JsonOps._
import org.http4s._
import org.http4s.dsl._

object EventsService {
  val service: AuthedService[User] = AuthedService {
    case GET -> Root / "events" as user => Ok {
      utils.Response.payload(user, Demo.events).format
    }
  }
}
