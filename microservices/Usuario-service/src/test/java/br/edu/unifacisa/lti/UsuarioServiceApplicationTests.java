package br.edu.unifacisa.lti;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

@SpringBootTest
class UsuarioServiceApplicationTests {
	
	private String requestBody = "{\n"
			+ "  \"id\": 0,\n"
			+ "  \"login\": \"string\",\n"
			+ "  \"senha\": \"string\",\n"
			+ "  \"email\": \"string\",\n"
			+ "  \"nickname\": \"string\"\n"
			+ "}";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
	@Test
	void testeListarUsuarios() {
		ValidatableResponse nextTitleLink =
				given()
				.when().log().all()
					.get("http://localhost:8765/usuario-service")
				.then().assertThat().statusCode(200);
		System.out.println(nextTitleLink);

	}
	
	@Test
	void testeObterUsuario() {
		Response response =
				given()
					.param("id", "1")
				.when().log().all()
					.get("http://localhost:8765/usuario-service/1")
				.then()
					.extract()
						.response();
		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertEquals("dhiogobn@gmail.com", response.jsonPath().getString("email"));
	}
	
	@Test
	void cadastrarUsuario() {
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("http://localhost:8765/usuario-service")
                .then()
                .extract().response();
		Assertions.assertEquals(200, response.statusCode());
		
		
		

	}


}
