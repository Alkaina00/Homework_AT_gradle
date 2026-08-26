package ru.alfa.homework17;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import io.restassured.RestAssured;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServeRestTest {
    private static String userId;
    private static String userEmail;
    private static String authToken;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("========================================");
        System.out.println("ВСЕ ТЕСТЫ ЗАВЕРШЕНЫ");
        System.out.println("========================================");
        System.out.println();
    }

    // Задание 2. «Кто здесь уже покупал?» — простой GET
    @Order(1)
    @Test
    public void shouldGetAllUsers() {
        given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("quantidade", greaterThan(0))
                .body("usuarios", not(empty()));

        System.out.println("Получен список всех пользователей");
    }

    // Задание 3. «Досье на клиента» — GET с query-параметром
    @Order(2)
    @Test
    public void shouldFindUserByEmail() {
        String userEmail = given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .extract()
                .path("usuarios[0].email");

        given()
                .queryParam("email", userEmail)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(1))
                .body("usuarios[0].email", equalTo(userEmail));

        System.out.println("Найден email первого пользователя: " + userEmail);
    }

    // Задание 4. «Открываем новый аккаунт» — POST
    @Order(3)
    @Test
    public void shouldCreateNewUser() {
        String uniqueEmail = "spy_" + System.currentTimeMillis() + "@qa.com";

        String requestBody = "{" +
                "\"nome\": \"Тайный покупатель\"," +
                "\"email\": \"" + uniqueEmail + "\"," +
                "\"password\": \"secret123\"," +
                "\"administrador\": \"true\"" +
                "}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", not(empty()))
                .extract()
                .response();

        userEmail = uniqueEmail;
        userId = response.path("_id");

        System.out.println("Создан пользователь с ID: " + userId);
    }

    // Задание 5. «Смена данных клиента» — PUT
    @Order(4)
    @Test
    public void shouldUpdateUser() {
        org.junit.jupiter.api.Assertions.assertNotNull(userId, "Сначала выполните shouldCreateNewUser()");

        String requestBody = "{" +
                "\"nome\": \"Обновлённый Покупатель\"," +
                "\"email\": \"" + userEmail + "\"," +
                "\"password\": \"secret123\"," +
                "\"administrador\": \"false\"" +
                "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .pathParam("id", userId)
                .when()
                .put("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));

        System.out.println("Обновлен пользователь с ID: " + userId);
    }

    // Задание 6. «Ключ от служебного входа» — авторизация + DELETE
    // Задание 6.1
    @Order(5)
    @Test
    public void shouldLogin() {
        org.junit.jupiter.api.Assertions.assertNotNull(userId, "Сначала выполните shouldCreateNewUser()");

        String requestBody = "{" +
                "\"email\": \"" + userEmail + "\"," +
                "\"password\": \"secret123\"" +
                "}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", not(empty()))
                .extract()
                .response();

        authToken = response.path("authorization");
        System.out.println("Получен токен: " + authToken);
    }

    // Задание 6.2
    @Order(6)
    @Test
    public void shouldDeleteUser() {
        given()
                .header("Authorization", authToken)
                .pathParam("id", userId)
                .when()
                .delete("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));

        System.out.println("Пользователь с ID " + userId + " удалён");

        given()
                .pathParam("id", userId)  // ← pathParam ДО get
                .when()
                .get("/usuarios/{id}")    // ← теперь {id} подставится
                .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));

        System.out.println("Проверка: пользователь не найден");
    }

    // Задание 7. «Каталог товаров» — GET + Hamcrest
    @Order(7)
    @Test
    public void shouldGetAllProducts() {
        String firstProductName = given()
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .extract()
                .path("produtos[0].nome");

        given()
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .body("quantidade", greaterThan(0))
                .body("produtos.preco", everyItem(greaterThan(0)))
                .body("produtos.nome", everyItem(not(empty())))
                .body("produtos.nome", hasItem(firstProductName));

        System.out.println("Проверка товаров завершена. Найден товар: " + firstProductName);
    }
}
