package api_adapters;

import com.google.gson.Gson;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public abstract class BaseAdapter {

    Gson converter = new Gson();

    public Response post(String url, String body) {
        return
                given()
                        .body(body)
                        .when()
                        .post(url)
                        .then()
                        .log().all()
                        .extract().response();
    }
}
