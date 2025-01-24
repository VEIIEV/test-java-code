package org.example.testjavacode.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

class UserListTest {

    private static final String BASE_URL = "https://reqres.in/api/users";

    @Test
    void testUserEmailsHaveCorrectDomain() {

        int pageNumber = 2;


        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("page", pageNumber)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();


        var emails = response.jsonPath().getList("data.email", String.class);

        emails.forEach(email -> {
            assertThat("Email должен оканчиваться на @reqres.in", email, endsWith("@reqres.in"));
        });

        System.out.println("Все Email  оканчиваются на @reqres.in");
    }
}