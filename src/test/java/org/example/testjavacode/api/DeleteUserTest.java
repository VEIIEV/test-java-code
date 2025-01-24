package org.example.testjavacode.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class DeleteUserTest {

    private static final String BASE_URL = "https://reqres.in/api/users";

    @Test
    void testDeleteSecondUser() {
        int userId = 2;

        given()
                .baseUri(BASE_URL)
                .when()
                .delete("/" + userId)
                .then()
                .statusCode(204);

        System.out.println("User ["+userId+"] was successfully deleted.");
    }
}
