package controlcenter

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SimulationsTest extends Simulation {

  val httpConf = http
    .baseUrl("XXX")

  val sentHeaders = Map(
    "Authorization" -> "Basic XXX",
    "Content-Type" -> "application/json"
  )

  val scn1 = scenario("Scenario1")
    .exec(
        http("Dashboard")
        .post("XXX")
        .body(StringBody("""{"XXX":"XXX"}"""))
        .headers(sentHeaders)
        .check(status.is(200))
    )

  /*setUp(
    scn1.inject(rampUsers(4000) during (60))
  ).protocols(httpConf)*/

  setUp(
      scn1.inject(constantConcurrentUsers(10) during(1))
    ).protocols(httpConf)
}


