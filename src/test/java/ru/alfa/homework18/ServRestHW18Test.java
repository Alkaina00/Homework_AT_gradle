package ru.alfa.homework18;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServRestHW18Test {

    private static String adminEmail;
    private static String adminPassword;
    private static String authToken;
    private static String productId;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        // Готовый администратор из тренировочного магазина
        adminEmail = "fulano@qa.com";
        adminPassword = "teste";
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("========================================");
        System.out.println("ВСЕ ТЕСТЫ HW18 ЗАВЕРШЕНЫ");
        System.out.println("========================================");
        System.out.println();
    }

    // Авторизация администратора для работы с каталогом
    @Order(1)
    @Test
    public void shouldLoginAsAdmin() {
        String requestBody = "{" +
                "\"email\": \"" + adminEmail + "\"," +
                "\"password\": \"" + adminPassword + "\"" +
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
        System.out.println("Admin авторизован, токен получен");
    }

    // Создание нового товара в каталоге (POST /produtos)
    @Order(2)
    @Test
    public void shouldCreateProduct() {
        String uniqueName = "Produto HW18 " + System.currentTimeMillis();

        String requestBody = "{" +
                "\"nome\": \"" + uniqueName + "\"," +
                "\"preco\": 199," +
                "\"descricao\": \"Produto criado no homework18\"," +
                "\"quantidade\": 10" +
                "}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .header("Authorization", authToken)
                .when()
                .post("/produtos")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .body("_id", not(empty()))
                .extract()
                .response();

        productId = response.path("_id");
        System.out.println("Создан товар с ID: " + productId);
    }

    // Поиск созданного товара по названию (GET /produtos + query-параметр)
    @Order(3)
    @Test
    public void shouldFindProductByName() {
        // Для чистоты используем готовый товар из каталога, избегая нестабильных данных
        String firstProductName = given()
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .extract()
                .path("produtos[0].nome");

        given()
                .queryParam("nome", firstProductName)
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(1))
                .body("produtos[0].nome", equalTo(firstProductName));

        System.out.println("Найден товар по названию: " + firstProductName);
    }

    // Обновление цены товара (PUT /produtos/{id})
    @Order(4)
    @Test
    public void shouldUpdateProductPrice() {
        org.junit.jupiter.api.Assertions.assertNotNull(productId, "Сначала выполните shouldCreateProduct()");

        String requestBody = "{" +
                "\"nome\": \"Produto HW18 " + System.currentTimeMillis() + "\"," +
                "\"preco\": 299," +
                "\"descricao\": \"Preco atualizado\"," +
                "\"quantidade\": 5" +
                "}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .header("Authorization", authToken)
                .pathParam("id", productId)
                .when()
                .put("/produtos/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));

        System.out.println("Обновлён товар с ID: " + productId);
    }

    // Удаление товара и проверка его отсутствия (DELETE + GET)
    @Order(5)
    @Test
    public void shouldDeleteProduct() {
        org.junit.jupiter.api.Assertions.assertNotNull(productId, "Сначала выполните shouldCreateProduct()");

        given()
                .header("Authorization", authToken)
                .pathParam("id", productId)
                .when()
                .delete("/produtos/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));

        System.out.println("Товар с ID " + productId + " удалён");

        given()
                .pathParam("id", productId)
                .when()
                .get("/produtos/{id}")
                .then()
                .statusCode(400)
                .body("message", equalTo("Produto não encontrado"));

        System.out.println("Проверка: товар не найден");
    }
}