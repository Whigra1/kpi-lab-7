import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirebaseTests
{
    private static final FireBaseEndPoint endPoint = new FireBaseEndPoint();

    private static final Map<Object, Object> data = new HashMap<>();


    @BeforeClass
    public static void createEndPoint()
    {
        data.put("id", 1);
        endPoint.deleteData("db/list.json");
    }

    @Test()
    public void AddData() {
        JSONObject jsonObj = new JSONObject(data);

        endPoint
                .AddData("/db/list.json", jsonObj)
                .then()
                .assertThat()
                .statusCode(200)
                .body(equalTo(jsonObj.toJSONString()));
    }

    @Test()
    public void AfterAddDataGet() {
        JSONObject jsonObj = new JSONObject(data);
        endPoint
            .getData("/db/list.json")
            .then()
            .assertThat()
            .statusCode(200)
            .body(equalTo(jsonObj.toJSONString()));
    }

    @Test()
    public void AppendData() {
        JSONObject jsonObj = new JSONObject(data);
        endPoint
            .postData("/db/list.json", jsonObj)
            .then()
            .assertThat()
            .statusCode(200);

    }

    @Test()
    public void afterAppendData() {
        endPoint
            .getData("/db/list.json")
            .then()
            .assertThat()
            .statusCode(200)
            .body(containsString("{\"id\":1}"));

    }

    @Test()
    public void deleteData() {
        endPoint
            .deleteData("/db/list.json")
            .then()
            .assertThat()
            .statusCode(200);
    }

    @Test()
    public void getDataAfterDelete() {
        endPoint
            .getData("/db/list.json")
            .then()
            .assertThat()
            .statusCode(200)
            .body(equalTo("null"));

    }
}
