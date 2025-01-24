package org.example.testjavacode.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class UpdateUserTest {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeAll
    static void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api/users")
                .setContentType("application/json")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    @Test
    void testUpdateUserWithPatch() {
        String requestBody = """
                {
                    "name": "morpheus",
                    "job": "zion resident"
                }
                """;

        String updatedAt = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .patch("/2")
                .then()
                .spec(responseSpec)
                .extract()
                .jsonPath()
                .getString("updatedAt");

        String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        assertThat(updatedAt, containsString(currentDate));

        System.out.println("user was updated at:" +  updatedAt);
    }
}
