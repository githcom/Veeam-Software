package apiEngine.endpoints.store;

import apiEngine.APIServiceBase;
import io.restassured.builder.RequestSpecBuilder;

public class StoreRequests extends APIServiceBase {

    private static final String BASE_PATH = "/store";

    public RequestSpecBuilder requestSpecBuilder(String endpoint) {
        return basicRequestSpecBuilder().setBasePath(BASE_PATH + endpoint);
    }

}
