package org.example.testjavacode;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class UserRegistrationTest {

    private static final String BASE_URL = "https://reqres.in/api/register";

    @Test
    void testSuccessfulRegistration() {
        // Тело запроса с валидными данными
        String validRequestBody = """
                {
                    "email": "eve.holt@reqres.in",
                    "password": "pistol"
                }
                """;

        Response response = given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(validRequestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
    }

    @Test
    void testRegistrationWithoutPassword() {
        String invalidRequestBody = """
                {
                    "email": "eve.holt@reqres.in"
                }
                """;

        Response response = given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(invalidRequestBody)
                .when()
                .post()
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"))
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
    }
}
