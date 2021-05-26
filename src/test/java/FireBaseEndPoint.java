import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


public class FireBaseEndPoint
{
    private static final String url = "https://kpi-lab5-default-rtdb.europe-west1.firebasedatabase.app/";

    public Response getData (String pathToData)
    {
        return given()
                .when()
                .get(pathToData)
                .then()
                .extract()
                .response();
    }


    public Response AddData(String pathToData, JSONObject data)
    {
        return given()
                .body(data.toJSONString())
                .when()
                .put(pathToData)
                .then()
                .extract()
                .response();
    }

    public Response deleteData(String path)
    {
        return given()
                .when()
                .delete(path)
                .then()
                .extract()
                .response();
    }

    public Response postData (String path, JSONObject data) {
        return given()
                .when()
                .body(data.toJSONString())
                .post(path)
                .then()
                .extract()
                .response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .baseUri(url)
                .contentType(ContentType.JSON);
    }
}
