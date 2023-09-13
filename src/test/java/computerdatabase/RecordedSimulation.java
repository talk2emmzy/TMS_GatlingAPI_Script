package computerdatabase;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://qa.fgntreasury.gov.ng")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("accept", "*/*"),
    Map.entry("accept-encoding", "gzip, deflate, br"),
    Map.entry("accept-language", "en-US,en;q=0.9"),
    Map.entry("access-control-request-headers", "content-type,device,ip,lat,long"),
    Map.entry("access-control-request-method", "POST"),
    Map.entry("origin", "https://qa.fgntreasury.gov.ng"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS")
  );
  
  private Map<CharSequence, String> headers_3 = Map.ofEntries(
    Map.entry("accept", "application/json, text/plain, */*"),
    Map.entry("accept-encoding", "gzip, deflate, br"),
    Map.entry("accept-language", "en-US,en;q=0.9"),
    Map.entry("content-type", "application/json"),
    Map.entry("device", "DELL"),
    Map.entry("ip", "105.113.69.38"),
    Map.entry("lat", "40.741895"),
    Map.entry("long", "-73.989308"),
    Map.entry("origin", "https://qa.fgntreasury.gov.ng"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("accept", "application/json, text/plain, */*"),
    Map.entry("accept-encoding", "gzip, deflate, br"),
    Map.entry("accept-language", "en-US,en;q=0.9"),
    Map.entry("device", "DELL"),
    Map.entry("ip", "105.113.69.38"),
    Map.entry("lat", "40.741895"),
    Map.entry("long", "-73.989308"),
    Map.entry("origin", "https://qa.fgntreasury.gov.ng"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site")
  );
  
  private Map<CharSequence, String> headers_6 = Map.ofEntries(
    Map.entry("accept", "application/json, text/plain, */*"),
    Map.entry("accept-encoding", "gzip, deflate, br"),
    Map.entry("accept-language", "en-US,en;q=0.9"),
    Map.entry("authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuZmZpbml0IiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY5MzIyNzc3M30.DqGlBa8xjkAKo0WAt9fOh_Stl1HWhoiFX02J8Qd-pbbU0T1IZXYXGrbE0x7_LrUuTaAGv34CKJ1eAiurwBLxVQ"),
    Map.entry("device", "DELL"),
    Map.entry("ip", "105.113.69.38"),
    Map.entry("lat", "40.741895"),
    Map.entry("long", "-73.989308"),
    Map.entry("origin", "https://qa.fgntreasury.gov.ng"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS"),
    Map.entry("sec-fetch-dest", "empty"),
    Map.entry("sec-fetch-mode", "cors"),
    Map.entry("sec-fetch-site", "same-site")
  );
  
  private String uri2 = "https://api-qa.fgntreasury.gov.ng";

  private ScenarioBuilder scn = scenario("RecordedSimulation")
    .exec(
      http("request_0")
        .options(uri2 + "/api/authenticate")
        .headers(headers_0)
    )
    .pause(1)
    .exec(
      http("request_1")
        .get("/static/media/coatOfArm.b61814ff3410d491ca4b.png")
        .headers(headers_1)
        .resources(
          http("request_2")
            .get("/static/media/avatar.988eb1c6471031178e81.png")
            .headers(headers_1),
          http("request_3")
            .post(uri2 + "/api/authenticate")
            .headers(headers_3)
            .body(RawFileBody("computerdatabase/recordedsimulation/0003_request.json")),
          http("request_4")
            .get("/static/media/eyeDisable.37abc76f84f64eaa4855894bce095e0c.svg")
            .headers(headers_1),
          http("request_5")
            .get(uri2 + "/services/organization/api/onboarding-step-two/organizations/64bd154645b00d68611793b9/banks")
            .headers(headers_5)
            .check(status().is(500)),
          http("request_6")
            .get(uri2 + "/services/organization/api/organizations/requests/awaiting-requests")
            .headers(headers_6),
          http("request_7")
            .get(uri2 + "/services/accountingservice/api/inflow/outflow/64bd154645b00d68611793b9")
            .headers(headers_6),
          http("request_8")
            .get(uri2 + "/api/organizations/64bd154645b00d68611793b9/total-payment")
            .headers(headers_6)
        )
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
