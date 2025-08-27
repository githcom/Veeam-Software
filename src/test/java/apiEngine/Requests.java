package apiEngine;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;

import static io.restassured.RestAssured.given;

public abstract class Requests {

    public static RequestSpecBuilder initialRequestSpecBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .setRelaxedHTTPSValidation();
    }

    public static Response get(RequestSpecBuilder specBuilder) {
        Response response = given().spec(specBuilder.build()).get();
        return validateResponseCode(response);
    }

    public static Response get(RequestSpecBuilder specBuilder, int statusCode) {
        Response response = given().spec(specBuilder.build()).get();
        return validateResponseCode(response, statusCode);
    }

    public static Response get(RequestSpecBuilder specBuilder, String relativePath) {
        Response response = given().spec(specBuilder.build()).get(relativePath);
        return validateResponseCode(response);
    }

    public static Response get(RequestSpecBuilder specBuilder, String relativePath, int statusCode) {
        Response response = given().spec(specBuilder.build()).get(relativePath);
        return validateResponseCode(response, statusCode);
    }

    public static Response getWithoutStatusCodeValidation(
            RequestSpecBuilder specBuilder, String relativePath) {
        return given().spec(specBuilder.build()).get(relativePath);
    }

    public static Response getWithoutStatusCodeValidation(RequestSpecBuilder specBuilder) {
        return given().spec(specBuilder.build()).get();
    }

    public static Response put(RequestSpecBuilder specBuilder) {
        Response response = given().spec(specBuilder.build()).put();
        return validateResponseCode(response);
    }

    public static Response put(RequestSpecBuilder specBuilder, String relativePath) {
        Response response = given().spec(specBuilder.build()).put(relativePath);
        return validateResponseCode(response);
    }

    public static Response put(RequestSpecBuilder specBuilder, int statusCode) {
        Response response = given().spec(specBuilder.build()).put();
        return validateResponseCode(response, statusCode);
    }

    public static Response putWithoutStatusCodeValidation(RequestSpecBuilder specBuilder) {
        return given().spec(specBuilder.build()).put();
    }

    public static Response putWithoutStatusCodeValidation(
            RequestSpecBuilder specBuilder, String relativePath) {
        return given().spec(specBuilder.build()).put(relativePath);
    }

    public static Response postWithoutStatusCodeValidation(RequestSpecBuilder specBuilder) {
        return given().spec(specBuilder.build()).post();
    }

    public static Response post(RequestSpecBuilder specBuilder) {
        Response response = given().spec(specBuilder.build()).post();
        return validateResponseCode(response);
    }

    public static Response post(RequestSpecBuilder specBuilder, String relativePath) {
        Response response = given().spec(specBuilder.build()).post(relativePath);
        return validateResponseCode(response);
    }

    public static Response post(RequestSpecBuilder specBuilder, int statusCode) {
        Response response = given().spec(specBuilder.build()).post();
        return validateResponseCode(response, statusCode);
    }

    public static Response postWithoutStatusCodeValidation(
            RequestSpecBuilder specBuilder, String relativePath) {
        return given().spec(specBuilder.build()).post(relativePath);
    }

    public static Response post(RequestSpecBuilder specBuilder, String relativePath, int statusCode) {
        Response response = given().spec(specBuilder.build()).post(relativePath);
        return validateResponseCode(response, statusCode);
    }

    public static Response delete(RequestSpecBuilder specBuilder) {
        Response response = given().spec(specBuilder.build()).delete();
        return validateResponseCode(response);
    }

    public static Response delete(RequestSpecBuilder specBuilder, int statusCode) {
        Response response = given().spec(specBuilder.build()).delete();
        return validateResponseCode(response, statusCode);
    }

    public static Response delete(RequestSpecBuilder specBuilder, String relativePath) {
        Response response = given().spec(specBuilder.build()).delete(relativePath);
        return validateResponseCode(response);
    }

    public static Response delete(
            RequestSpecBuilder specBuilder, String relativePath, int statusCode) {
        Response response = given().spec(specBuilder.build()).delete(relativePath);
        return validateResponseCode(response, statusCode);
    }

    protected static Response validateResponseCode(Response response) {
        return validateResponseCode(response, HttpStatus.SC_OK);
    }

    protected static Response validateResponseCode(Response response, int statusCode) {
        try {
            Assertions.assertThat(response.statusCode()).as("Status code").isEqualTo(statusCode);
        } catch (AssertionError e) {
            String oldMessage = e.getMessage();
            String newMessage =
                    String.format("%s \n Response: %s \n", oldMessage, response.body().asString());
            throw new AssertionError(newMessage);
        }
        return response;
    }
}
