package controlcenter

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SimulationsUpdateAlarms extends Simulation {

  val httpConf = http
    .baseUrl("https://preprod-controlcenter.exotec.com")

  val sentHeaders = Map(
    "Authorization" -> "Basic V0NTIERldmVsb3BtZW50OllsYTVHaXNreFU2dkhFVE9Nd3BXK2dDb3liU0xRRmhtdFg7RCkodT1CTlAmSkEzcg==",
    "Content-Type" -> "application/json"
  )

  val scn1 = scenario("Scenario1")
    .exec(
        http("Dashboard")
        .post("/external-api/alarm")
        .body(StringBody("""{"type":"SQL","output":[{"site":"WCS Development","value":2,"code":"TESTALARM","detail":"SystemStatus:Operational","record_at":"2023-02-15 15:13:00","occurred_at":"2023-02-15 15:13:00"}]}"""))
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


