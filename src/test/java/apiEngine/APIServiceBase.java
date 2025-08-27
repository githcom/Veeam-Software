package apiEngine;

import configs.TestConfig;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigCache;

public abstract class APIServiceBase extends Requests {

    protected TestConfig config = ConfigCache.getOrCreate(TestConfig.class);
    private final String BASE_URI = config.hostUrl();

    public RequestSpecBuilder basicRequestSpecBuilder() {
        var basicAauth = new BasicAuthScheme();
        basicAauth.setUserName("user4");
        basicAauth.setPassword("hlB5U1rA");
//        basicAauth.setUserName(System.getenv("user"));
//        basicAauth.setPassword(System.getenv("password"));
        return initialRequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Content-Type", ContentType.JSON.toString())
                .setAuth(basicAauth);
    }
}
